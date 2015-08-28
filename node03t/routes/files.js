var express = require('express');
var multer = require('multer');

//업로드 파일에 대한 설정
var storage = multer.diskStorage({
destination: function (req, file, cb) { // 저장위치
  cb(null, 'www/files')
},
filename: function (req, file, cb) { // 새 파일명
  var i = file.originalname.lastIndexOf('.');
  var ext = file.originalname.substr(i);
  cb(null, Date.now() + ext);
}
})

//multer 객체를 통해 업로드 도구를 준비한다.
var upload = multer({ storage: storage })

var router = express.Router();

router.post('/upload.do'
  , upload.single('file')
  , function(request, response) {
    response.writeHead(200,{'Content-Type': 'text/html;charset=UTF-8'});
    response.write('<!DOCTYPE html>\n');
    response.write('<html>\n');
    response.write('<head>\n');
    response.write('<meta charset="UTF-8">\n');
    response.write('<title>파일업로드</title></head>\n');
    response.write('<body>\n');
    response.write('<h1>파일 업로드 결과</h1>\n');
    response.write('<p>\n');
    response.write('필드명:' + request.file.fieldname + '<br>\n');
    response.write('원래 파일명:' + request.file.originalname + '<br>\n');
    response.write('파일명:' + request.file.filename + '<br>\n');
    response.write('파일크기:' + request.file.size + '<br>\n');
    response.write('저장폴더경로:' + request.file.destination + '<br>\n');
    response.write('전체파일경로:' + request.file.path + '<br>\n');
    response.write('<p><a href="' + request.file.filename + '" \n');
    response.write('  target="_blank">' + request.file.filename + '</a></p>\n');
    response.write('</p>\n');
    response.write('</body>\n');
    response.write('</html>\n');
    response.end();
});


module.exports = router;










