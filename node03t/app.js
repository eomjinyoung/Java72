var express = require('express');
var bodyParser = require('body-parser');

var app = express();

app.use(bodyParser.json());
app.use(bodyParser.urlencoded({
  extended: true
}));

var board = require('./routes/board');
app.use('/board', board);


app.get('/', function (req, res) {
  res.send('Hello World!');
});

var server = app.listen(8888, function () {
  var host = server.address().address;
  var port = server.address().port;

  console.log('서버 실행 중: http://%s:%s', host, port);
});




