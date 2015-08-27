var bit = require('./bit.js');
var mysql = require('mysql');
var url = require('url');
var querystring = require('querystring');

bit.listen('8888');
console.log('서버 가동 중...');

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

bit.get('/board/form.do', function(request, response) {
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
});

bit.get('/board/list.do', function(request, response) {
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
});

bit.post('/board/insert.do', function(request, response) {
  var messageBody = '';
  request.on('data', function(data) {
    messageBody += data;
  });
  
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
});

bit.get('/board/view.do', function(request, response) {
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
    response.write('<h1>게시글 상세정보</h1>\n');
    
    if (rows.length > 0) {
      response.write('<form action="update.do" method="post">\n');
      response.write('번호: <input type="text" name="no" \n');
      response.write('            value="' + rows[0].bno + '"><br>\n');
      response.write('제목: <input type="text" name="title" \n');
      response.write('            value="' + rows[0].title + '"><br>\n');
      response.write('내용: <textarea name="content" rows="5" \n');
      response.write('      cols="30">' + rows[0].content + '</textarea><br>\n');
      response.write('등록일: ' + rows[0].cre_dt + '<br>\n');
      response.write('조회수: ' + rows[0].views + '<br>\n');
      response.write('<button>변경</button>\n');
      response.write('<a href="delete.do?no=' + rows[0].bno + '">삭제</a>\n');
      response.write('<a href="list.do">목록</a>\n');
      response.write('</form>\n');
    } else {
      response.write('<p>해당 게시물이 존재하지 않습니다.</p>\n'); 
    }
    
    response.write('</body></html>\n');
    response.end();
  });
});

bit.post('/board/update.do', function(request, response) {
  var messageBody = '';
  request.on('data', function(data) {
    messageBody += data;
  });
  
  request.on('end', function() {
    var params = querystring.parse(messageBody);
    pool.query(
        'update board10 set title=?,content=?'
          + ' where bno=?',
        [ params.title,
          params.content,
          params.no ],
        function(err, rows) {
          response.writeHead(200, {
            'Content-Type': 'text/html;charset=UTF-8',
            'Refresh': '0;url=list.do'      
          });
          response.end();
      });
  });
});

bit.get('/board/delete.do', function(request, response) {
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
});

bit.error(function(request, response) {
  response.writeHead(200,{'Content-Type': 'text/html;charset=UTF-8'});
  response.write('<html><head>\n');
  response.write('<title>요청 결과</title></head>\n');
  response.write('<body>\n');
  response.write('<p>지원하지 않는 URL입니다.</p>');
  response.write('</body></html>\n');
  response.end();
});








