var mysql = require('mysql');
var express = require('express');

var pool = mysql.createPool({
  connectionLimit: 10,
  host: 'localhost',
  port: 3306,
  user: 'java72',
  password: 'java72',
  database: 'java72db'
});

var router = express.Router();

router.get('/existEmail.do', function(request, response) {
  pool.query(
      'select count(*) as cnt'
      + ' from member where email=?',
      [request.query['email']],
      function(err, rows) {
    response.writeHead(200,{
      'Content-Type': 'application/json;charset=UTF-8',
      'Access-Control-Allow-Origin': '*'
    });
    
    var cnt = rows[0].cnt;
    var result = {};
    if (cnt > 0) {
      result.data = 'yes';
    } else {
      result.data = 'no';
    }
    
    response.end(JSON.stringify(result));
  });
});


module.exports = router;










