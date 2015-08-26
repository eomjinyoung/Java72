var http = require('http');
http.createServer(
    function(request, response) {
      console.log('오호라.. 클라이언트가 요청했네..');
      response.writeHead(
          200,
          {
            'Content-Type': 'text/plain;charset=UTF-8'
          });
      response.end('반갑다!');
}).listen(8888, '127.0.0.1');
console.log('서버 가동 중...');