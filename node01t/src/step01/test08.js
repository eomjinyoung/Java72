// 요청 URL로부터 상세 정보 추출하기
var http = require('http');
// URL 분석기를 로딩한다.
var url = require('url');

http.createServer(
    function(request, response) {
      if (request.url == '/favicon.ico') {
        response.end();
        return;
      }
      // URL 분석하기
      var urlInfo = url.parse(request.url);
      
      // URL 전체 내용 출력
      console.log('href = ', urlInfo.href);
      
      // 웹 애플리케이션 경로 
      console.log('pathname = ', urlInfo.pathname);
      
      // 클라이언트가 보낸 데이터
      console.log('search = ', urlInfo.search);
      
      // 쿼리 스트링
      console.log('query = ', urlInfo.query);
      
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









