define(['jquery'], function($) {
  $('#main > header').load('header.html');
  $('#main > footer').load('footer.html');
  $('#content').load('sub/auth.html');

  $('#boardMenu').click(function(event) {
    event.preventDefault();
    $('#content').load('sub/board.html');
  });

  $('#memberMenu').click(function(event) {
    event.preventDefault();
    $('#content').load('sub/member.html');
  });

  $(document).on('login.success', function(event) {
    //특정 모듈만 가져오기
    var header = require('app/header');
    header.loadLoginInfo();
    $('#content').load('sub/board.html');
  });

  $(document).on('logout.success', function(event) {
    $('#content').load('sub/auth.html');
    var header = require('app/header');
    header.loadLoginInfo();
  });

});











