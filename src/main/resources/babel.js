/*global process, require */

var fs = require('fs'),
jst = require('jstranspiler'),
nodefn = require('when/node'),
mkdirp = require('mkdirp'),
path = require('path'),
babel = require('babel-core');

var promised = {
    mkdirp: nodefn.lift(mkdirp),
    readFile: nodefn.lift(fs.readFile),
    writeFile: nodefn.lift(fs.writeFile)
};

var args = jst.args(process.argv);

function processor(input, output) {
    return promised.readFile(input, 'utf8').then(function(contents) {
        var result;

        var options = args.options;
        options.filename = input;

        try {
            result = {
                code: babel.transform(contents, options).code
            };
        } catch (err) {
            throw parseError(input, contents, err);
        }
        return result;
    }).then(function(result) {
        return promised.mkdirp(path.dirname(output)).yield(result);
    }).then(function(result) {
        return promised.writeFile(output, result.code, 'utf8').yield(result);
    }).then(function(result) {
        return {
            source: input,
            result: {
                filesRead: [input],
                filesWritten: [output]
            }
        };
    }).catch(function(e) {
        if (jst.isProblem(e)) return e; else throw e;
    });
}

jst.process({
    processor: processor,
    inExt: /\.(es6\.js|es6|jsx\.js|jsx|react\.js)$/,
    outExt: '.js'
}, args);

function parseError(input, contents, err) {
    var hasLocation = !!err.loc;
    var lines = hasLocation ? contents.split('\n', err.loc.line) : [];
    return {
        message: err.message,
        severity: 'error',
        lineNumber: hasLocation ? err.loc.line : 0,
        characterOffset: hasLocation ? err.loc.column : -1,
        lineContent: hasLocation ? (err.loc.line > 0 ? lines[err.loc.line - 1] : 'unknown') : '',
        source: input
    };
}


