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
  $('#content').load('sub/board.html');
  loadLoginInfo();
});

$(document).on('logout.success', function(event) {
  $('#content').load('sub/auth.html');
  loadLoginInfo();
});











