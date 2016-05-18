var express = require('express');
var router = express.Router();
var post2Url = require('../post2Url');

/* GET users listing. */
router.get('/', function (req, res, next) {
    req.body.token = req.session.token;
    post2Url.post(req, '/user/', function (rmres, data) {
        if (rmres.statusCode == 200) {
            var obj = JSON.parse(data);
            if (obj.code === 0) {
                res.render('user', obj);
            } else if (obj.code === 6) {
                res.render('index', {title: 'web2', name: '国米'});
            } else {
                res.write(data);
                res.end();
            }
        } else {
            res.write(data);
            res.end();
        }
    });
});

router.post('/login', function (req, res, next) {
    post2Url.post(req, '/user/login', function (rmres, data) {
        if (rmres.statusCode == 200) {
            var obj = JSON.parse(data);
            if (obj.code === 0) {
                console.log(obj.token);
                req.session.token = obj.token;
            }
            res.json(rmres.statusCode, obj);
        } else {
            res.json(rmres.statusCode, data);
        }
    });
});

module.exports = router;