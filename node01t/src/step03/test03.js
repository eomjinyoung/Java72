var http = require('http');
var url = require('url');

var requestMapper = {
    '/board/list.do': doList,
    '/board/form.do': doForm,
    '/board/insert.do': doInsert,
    '/board/view.do': doView,
    '/board/update.do': doUpdate,
    '/board/delete.do': doDelete,
};

http.createServer(
    function(request, response) {
      var urlInfo = url.parse(request.url, true);
      
      var handler = requestMapper[urlInfo.pathname];
      if (handler) {
        handler(request, response);
      } else {
        doError(request, response);
      }

}).listen(8888, '127.0.0.1');
console.log('서버 가동 중...');

function doForm(request, response) {
  response.writeHead(200,{'Content-Type': 'text/html;charset=UTF-8'});
  response.write('<html><head>\n');
  response.write('<title>게시판</title></head>\n');
  response.write('<body>\n');
  response.write('<h1>새 게시글</h1>\n');
  response.write('<form action="insert.do" method="get">\n');
  response.write('제목: <input type="text" name="title"><br>\n');
  response.write('내용: <textarea name="content"\n'); 
  response.write('     rows="3" cols="20"></textarea><br>\n');
  response.write('<button>등록</button>\n');
  response.write('</form>\n');
  response.write('</body></html>\n');
  response.end();
}

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








