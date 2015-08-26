// 클라이언트로 출력하기 
// write() 함수 사용법 
var http = require('http');
http.createServer(
    function(request, response) {
      console.log('오호라.. 클라이언트가 요청했네..');
      response.writeHead(
          200,
          {
            'Content-Type': 'text/plain;charset=UTF-8'
          });
      
      response.write('오호라... 출력이네..');
      response.write('맞아, 출력이야.');

      // 클라이언트로의 응답을 완료하려면 반드시 end()를 호출해야 한다.
      response.end();
      
}).listen(8888, '127.0.0.1');
console.log('서버 가동 중...');









