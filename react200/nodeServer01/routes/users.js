var express = require('express');
var router = express.Router();

router.get('/', function(req, res, next) {
  res.send('호랑이');
});

router.get('/2', function(req, res, next) {
  res.send({'message':'독수리'});
});

router.post('/2', function(req, res) {
  console.log(req.body);
  // let obj = req.body;
  // let {name, age} = req.body;
  console.log(req.body.name);
  req.body.name += 100;

  res.send(req.body);
});

module.exports = router;
