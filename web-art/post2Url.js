var http = require('http');
var querystring = require('querystring');

var remoteHost = 'localhost';
var remotePort = 9999;

exports.get = function (req, url, success) {

    var options = {
        hostname: remoteHost,
        port: remotePort,
        path: url,
        method: 'get'
    };

    var req = http.request(options, function (res) {
        res.setEncoding('utf8');
        res.on('data', function (data) {
            success(res, data);
        });
    });

    req.on('error', function (e) {
        console.log('problem with request: ' + e.message);
    });

    req.end();
}

exports.post = function (req, url, success) {
    var post_data = req.body;
    var content = querystring.stringify(post_data);
    var options = {
        host: remoteHost,
        port: remotePort,
        path: url,
        method: 'post',
        headers: {
            'Content-Type': 'application/x-www-form-urlencoded; charset=UTF-8'
        }
    };

    var req = http.request(options, function (res) {
        res.setEncoding('utf8');
        res.on('data', function (data) {
            success(res, data);
        });
    });

    req.on('error', function (e) {
        console.log("auth_user error: " + e.message);
    });

    req.write(content);
    req.end();
}