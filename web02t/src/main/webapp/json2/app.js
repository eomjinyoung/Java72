$('#main > header').load('header.html');
$('#main > footer').load('footer.html');

$('#boardMenu').click(function(event) {
  $('#content').load('sub/board.html');
});

$('#memberMenu').click(function(event) {
  $('#content').load('sub/member.html');
});