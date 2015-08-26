// 특정 URL에만 반응하기: 계산기 응용
var http = require('http');
var url = require('url');

http.createServer(
    function(request, response) {
      var urlInfo = url.parse(request.url, true);
      response.writeHead(200,{'Content-Type': 'text/html;charset=UTF-8'});
      
      response.write('<html><head>\n');
      response.write('<title>요청 결과</title></head>\n');
      response.write('<body>\n');
      
      var result = 0,
          v1 = parseInt(urlInfo.query.v1),
          v2 = parseInt(urlInfo.query.v2);
      
      if (urlInfo.pathname == '/plus') {
        result = v1 + v2;
        response.write(v1 + ' + ' + v2 + ' = ' + result);
      } else if (urlInfo.pathname == '/minus') {
        result = v1 - v2;
        response.write(v1 + ' - ' + v2 + ' = ' + result);
      } else if (urlInfo.pathname == '/multiple') {
        result = v1 * v2;
        response.write(v1 + ' * ' + v2 + ' = ' + result);
      } else {
        response.write('해당 URL을 지원하지 않습니다.'); 
      }
      
      response.write('</body></html>\n');
      response.end();
      
}).listen(8888, '127.0.0.1');
console.log('서버 가동 중...');









