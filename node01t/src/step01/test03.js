//1) http 모듈 로딩
var http = require('http');

//2) HTTP 서버 객체 준비
var httpServer = http.createServer(
    function(request, response) {
      console.log('오호라.. 클라이언트가 요청했네..');
      response.writeHead(
          200,
          {
            'Content-Type': 'text/plain;charset=UTF-8'
          });
      response.end('반갑다!');
    });

//3) HTTP 서버 시작
httpServer.listen(8888, '127.0.0.1');

console.log('서버 가동 중...');