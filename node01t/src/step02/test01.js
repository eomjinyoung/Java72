// DBMS 연동: select
var http = require('http');
var url = require('url');
var mysql = require('mysql');

var con = mysql.createConnection({
  host: 'localhost',
  port: 3306,
  user: 'java72',
  password: 'java72',
  database: 'java72db'
});

con.connect();

con.query('select bno,title,cre_dt from board10', 
  function(err, rows) {
    if (err) {
      console.log(err);
      return;
    }
    
    for (var i in rows) {
      console.log(
          rows[i].bno, rows[i].title);
    }
    con.end();
});





