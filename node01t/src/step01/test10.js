// 파라미터 값 응용!
var http = require('http');
var url = require('url');

http.createServer(
    function(request, response) {
      if (request.url == '/favicon.ico') {
        response.end();
        return;
      }
      
      var urlInfo = url.parse(request.url, true);
      var name = urlInfo.query.name;
      var age = parseInt(urlInfo.query.age);
      
      response.writeHead(
          200,
          {
            'Content-Type': 'text/html;charset=UTF-8'
          });
      
      response.write('<html><head>\n');
      response.write('<title>okok</title></head>\n');
      response.write('<body>\n');
      response.write('나이: ' + (age + 10) + '<br>\n');
      response.write('이름: ' + name + '<br>\n');
      response.write('</body></html>\n');
      response.end();
      
}).listen(8888, '127.0.0.1');
console.log('서버 가동 중...');









