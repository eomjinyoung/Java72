var http = require('http');
var url = require('url');

var getMapper = {};
var postMapper = {};
var onError = null;

exports.get = function (url, callback) {
  getMapper[url] = callback;
};

exports.post = function (url, callback) {
  postMapper[url] = callback;
};

exports.listen = function (port) {
  http.createServer(function (request, response) {
    var urlInfo = url.parse(request.url, true);
    var handler = null;

    if (request.method == 'GET') {
      handler = getMapper[urlInfo.pathname];
    } else { // 'POST
      handler = postMapper[urlInfo.pathname];
    }
    
    if (handler) {
      handler(request, response);
    } else {
      onError(request, response);
    }
  }).listen(port);
};
  
exports.error = function (callback) {
  onError = callback;
}; 
  
  




  
  
  
  