//$('#loginBtn').on('click', function(event) {});
$('#loginBtn').click(function(event) {
  $.getJSON('login.do', 
    {
      email: $('#email').val(),
      password: $('#password').val()
    },
    function(result) {
      if (result.data == 'yes') {
        location.href = '../board/index.html';
      } else {
        $('#message').text('이메일 또는 암호가 맞지 않습니다.');
      }
  });
});

$('input').focus(function(event) {
  $('#message').text('');
});













