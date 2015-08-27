// DBMS 연동: select
var mysql = require('mysql');

var con = mysql.createConnection({
  host: 'localhost',
  port: 3306,
  user: 'java72',
  password: 'java72',
  database: 'java72db'
});

con.connect();

con.query(
  'insert into board10(title, cre_dt) values(?,now())',
  ['okok'],
  function(err, rows) {
    if (err) {
      console.log(err);
      return;
    }
    
    console.log('입력 성공!');
    
    con.end();
});





