var http = require('http');
var url = require('url');
var mysql = require('mysql');

var pool = mysql.createPool({
  connectionLimit: 10,
  host: 'localhost',
  port: 3306,
  user: 'java72',
  password: 'java72',
  database: 'java72db'
});

pool.on('connection', function(connection) {
  console.log('커넥션 생성됨.');
});

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

}).listen(8888);
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

function doList(request, response) {
  var urlInfo = url.parse(request.url, true);
  pool.query('select bno,title,cre_dt,views from board10', 
      function(err, rows) {
        response.writeHead(200,{'Content-Type': 'text/html;charset=UTF-8'});
        response.write('<html><head>\n');
        response.write('<title>게시글 목록</title></head>\n');
        response.write('<body>\n');
        response.write('<h1>게시글 목록</h1>');
        response.write('<table>');
        response.write('<tr>');
        response.write('  <th>번호</th>');
        response.write('  <th>제목</th>');
        response.write('  <th>조회수</th>');
        response.write('</tr>');
        if (err) {
          resopnse.write(err);
        } else { 
          for (var i in rows) {
            response.write('<tr>');
            response.write('  <td>' + rows[i].bno + '</td>');
            response.write('  <td>'
                + '<a href="view.do?no=' 
                + rows[i].bno 
                + '">'
                + rows[i].title
                + '</a>'
                + '</td>');
            response.write('  <td>' + rows[i].views + '</td>');
            response.write('</tr>');
          }
          
        }
        response.write('</table>');
        response.write('</body></html>\n');
        response.end();
    });
}

function doInsert(request, response) {
  var urlInfo = url.parse(request.url, true);
  response.writeHead(200,{'Content-Type': 'text/html;charset=UTF-8'});
  response.write('<html><head>\n');
  response.write('<title>게시글 등록</title></head>\n');
  response.write('<body>\n');
  response.write('<h1>등록 결과</h1>');
  response.write('</body></html>\n');
  response.end();
}

function doView(request, response) {
  var urlInfo = url.parse(request.url, true);
  pool.query(
      'select bno,title,content,cre_dt,views'
      + ' from board10 where bno=?',
      [urlInfo.query.no],
      function(err, rows) {
    response.writeHead(200,{'Content-Type': 'text/html;charset=UTF-8'});
    response.write('<html><head>\n');
    response.write('<title>게시글 조회</title></head>\n');
    response.write('<body>\n');
    response.write('<h1>게시글 상세정보</h1>');
    
    if (rows.length > 0) {
      response.write('<form action="update.do" method="get">');
      response.write('번호: <input type="text" name="no" ');
      response.write('            value="' + rows[0].bno + '"><br>');
      response.write('제목: <input type="text" name="title" ');
      response.write('            value="' + rows[0].title + '"><br>');
      response.write('내용: <textarea name="content" rows="5" ');
      response.write('      cols="30">' + rows[0].content + '</textarea><br>');
      response.write('등록일: ' + rows[0].cre_dt + '<br>');
      response.write('조회수: ' + rows[0].views + '<br>');
      response.write('<button>변경</button>');
      response.write('<a href="delete.do?no=' + rows[0].bno + '">삭제</a>');
      response.write('<a href="list.do">목록</a>');
      response.write('</form>');
    } else {
      response.write('<p>해당 게시물이 존재하지 않습니다.</p>\n'); 
    }
    
    response.write('</body></html>\n');
    response.end();
  });
}

function doUpdate(request, response) {
  var urlInfo = url.parse(request.url, true);
  response.writeHead(200,{'Content-Type': 'text/html;charset=UTF-8'});
  response.write('<html><head>\n');
  response.write('<title>게시글 변경</title></head>\n');
  response.write('<body>\n');
  response.write('<h1>변경 결과</h1>');
  response.write('</body></html>\n');
  response.end();
}

function doDelete(request, response) {
  var urlInfo = url.parse(request.url, true);
  response.writeHead(200,{'Content-Type': 'text/html;charset=UTF-8'});
  response.write('<html><head>\n');
  response.write('<title>게시글 삭제</title></head>\n');
  response.write('<body>\n');
  response.write('<h1>삭제 결과</h1>');
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








