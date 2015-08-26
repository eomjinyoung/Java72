// 파라미터 값 알아내기 
var http = require('http');
var url = require('url');

http.createServer(
    function(request, response) {
      if (request.url == '/favicon.ico') {
        response.end();
        return;
      }
      
      // URL에서 파라미터 정보를 따로 분리하고 싶다면, 
      // parse()의 두 번째 파라미터 값을 true로 설정하라!
      var urlInfo = url.parse(request.url, true);
      console.log('pathname = ', urlInfo.pathname);
      console.log('title = ', urlInfo.query.title);
      console.log('content = ', urlInfo.query.content);
      
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









