// 요청 정보 알아내기 
var http = require('http');
http.createServer(
    function(request, response) {
      if (request.url == '/favicon.ico') {
        response.end();
        return;
      }
      //요청 헤더
      console.log(request.headers);
      
      //요청 방법(GET, POST, ...)
      console.log('method = ', request.method);
      
      //요청 URL
      console.log('url = ', request.url);
      
      response.writeHead(
          200,
          {
            'Content-Type': 'text/html;charset=UTF-8'
          });
      
      response.write('<html><head>'
          + '<title>okok</title></head>');
      response.write('<body><h1>하하하</h1></body></html>');

      // 클라이언트로의 응답을 완료하려면 반드시 end()를 호출해야 한다.
      response.end();
      
}).listen(8888, '127.0.0.1');
console.log('서버 가동 중...');









