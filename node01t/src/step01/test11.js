// 특정 URL에만 반응하기
var http = require('http');
var url = require('url');

http.createServer(
    function(request, response) {
      var urlInfo = url.parse(request.url, true);
      response.writeHead(200,{'Content-Type': 'text/html;charset=UTF-8'});
      
      response.write('<html><head>\n');
      response.write('<title>요청 결과</title></head>\n');
      response.write('<body>\n');
      
      if (urlInfo.pathname == '/hello') {
        var name = urlInfo.query.name;
        var age = parseInt(urlInfo.query.age);
        response.write('나이: ' + (age + 10) + '<br>\n');
        response.write('이름: ' + name + '<br>\n');

      } else {
        response.write('해당 URL을 지원하지 않습니다.'); 
      }
      
      response.write('</body></html>\n');
      response.end();
      
}).listen(8888, '127.0.0.1');
console.log('서버 가동 중...');









