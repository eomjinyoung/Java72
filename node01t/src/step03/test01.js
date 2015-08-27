var http = require('http');
var url = require('url');

http.createServer(
    function(request, response) {
      var urlInfo = url.parse(request.url, true);
      
      switch (urlInfo.pathname) {
      case '/calc/plus.do': doPlus(request, response); break;
      case '/calc/minus.do': doMinus(request, response); break;
      case '/calc/multiple.do': doMultiple(request, response); break;
      default: doError(request, response);
      }
}).listen(8888, '127.0.0.1');
console.log('서버 가동 중...');

function doPlus(request, response) {
  var urlInfo = url.parse(request.url, true);
  response.writeHead(200,{'Content-Type': 'text/html;charset=UTF-8'});
  response.write('<html><head>\n');
  response.write('<title>요청 결과</title></head>\n');
  response.write('<body>\n');
  
  var result = 0,
  v1 = parseInt(urlInfo.query.v1),
  v2 = parseInt(urlInfo.query.v2);
  result = v1 + v2;
  
  response.write(v1 + ' + ' + v2 + ' = ' + result);
  
  response.write('</body></html>\n');
  response.end();
}

function doMinus(request, response) {
  var urlInfo = url.parse(request.url, true);
  response.writeHead(200,{'Content-Type': 'text/html;charset=UTF-8'});
  response.write('<html><head>\n');
  response.write('<title>요청 결과</title></head>\n');
  response.write('<body>\n');
  
  var result = 0,
  v1 = parseInt(urlInfo.query.v1),
  v2 = parseInt(urlInfo.query.v2);
  result = v1 - v2;
  
  response.write(v1 + ' - ' + v2 + ' = ' + result);
  
  response.write('</body></html>\n');
  response.end();
}

function doMultiple(request, response) {
  var urlInfo = url.parse(request.url, true);
  response.writeHead(200,{'Content-Type': 'text/html;charset=UTF-8'});
  response.write('<html><head>\n');
  response.write('<title>요청 결과</title></head>\n');
  response.write('<body>\n');
  
  var result = 0,
  v1 = parseInt(urlInfo.query.v1),
  v2 = parseInt(urlInfo.query.v2);
  result = v1 * v2;
  
  response.write(v1 + ' * ' + v2 + ' = ' + result);
  
  response.write('</body></html>\n');
  response.end();
}

function doError(request, response) {
  response.writeHead(200,{'Content-Type': 'text/html;charset=UTF-8'});
  response.write('<html><head>\n');
  response.write('<title>요청 결과</title></head>\n');
  response.write('<body>\n');
  response.write('<p>지원하지 않는 URL입니다.</p>');
  response.write('</body></html>\n');
  response.end();
}








