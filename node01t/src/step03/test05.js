var http = require('http');
var url = require('url');
var mysql = require('mysql');
var querystring = require('querystring');

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
  response.write('<form action="insert.do" method="post">\n');
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
  pool.query(
    'select bno,title,cre_dt,views from board10'
        + ' order by bno desc', 
    function(err, rows) {
      response.writeHead(200,{'Content-Type': 'text/html;charset=UTF-8'});
      response.write('<html><head>\n');
      response.write('<title>게시글 목록</title></head>\n');
      response.write('<body>\n');
      response.write('<h1>게시글 목록</h1>\n');
      response.write('<p><a href="form.do">새 글</a></p>\n');
      response.write('<table>\n');
      response.write('<tr>\n');
      response.write('  <th>번호</th>\n');
      response.write('  <th>제목</th>\n');
      response.write('  <th>조회수</th>\n');
      response.write('</tr>\n');
      if (err) {
        resopnse.write(err);
      } else { 
        for (var i in rows) {
          response.write('<tr>\n');
          response.write('  <td>' + rows[i].bno + '</td>\n');
          response.write('  <td>'
              + '<a href="view.do?no=' 
              + rows[i].bno 
              + '">'
              + rows[i].title
              + '</a>'
              + '</td>\n');
          response.write('  <td>' + rows[i].views + '</td>\n');
          response.write('</tr>\n');
        }
        
      }
      response.write('</table>\n');
      response.write('</body></html>\n');
      response.end();
  });
}

function doInsert(request, response) {
  //POST 요청일 때는 url로부터 데이터를 추출할 수 없다.
  //HTTP 프로토콜에서 message-body 부분의 데이터를 추출해야 한다.
  //다음은 message-body 부분의 데이터를 추출하는 코드이다.
  
  //1) data 이벤트: message-body의 데이터를 읽을 때 마다 발생한다.
  //   => 한 번에 읽는 것이 아니다. 
  //   => 클라이언트가 보내는데 데이터의 양에 따라 여러 번 읽는다.
  //   => 읽을 때 마다 데이터를 임시 변수에 보관한다.
  var messageBody = '';
  request.on('data', function(data) {
    messageBody += data;
  });
  
  //2) end 이벤트: message-body의 데이터를 모두 읽었을 때 발생한다.
  //   => 데이터를 모두 읽었으면, 변수와 값 형태로 분리하여 객체에 저장한다.
  request.on('end', function() {
    // '변수=값&변수=값&변수=값' 문자열 분석은 외부 객체에 맡기자.
    var params = querystring.parse(messageBody);
    pool.query(
        'insert into board10(title,content,cre_dt)'
          + ' values(?,?,now())',
        [ params.title,
          params.content],
        function(err, rows) {
          response.writeHead(200, {
            'Content-Type': 'text/html;charset=UTF-8',
            'Refresh': '0;url=list.do'      
          });
          response.end();
      });
  });
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
  pool.query(
    'update board10 set title=?,content=?'
      + ' where bno=?',
    [ urlInfo.query.title,
      urlInfo.query.content,
      urlInfo.query.no ],
    function(err, rows) {
      response.writeHead(200, {
        'Content-Type': 'text/html;charset=UTF-8',
        'Refresh': '0;url=list.do'      
      });
      response.end();
  });
}

function doDelete(request, response) {
  var urlInfo = url.parse(request.url, true);
  pool.query(
      'delete from board10 where bno=?',
      [ urlInfo.query.no ],
      function(err, rows) {
        response.writeHead(200, {
          'Content-Type': 'text/html;charset=UTF-8',
          'Refresh': '0;url=list.do'      
        });
        response.end();
    });
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








