define(['jquery','app/common'], function($) {
  return {
    init: function() {
      $('#login2Btn').click(function(event) {
        event.preventDefault();
        $.getJSON(contextRoot + '/json/auth/login.do', 
            {
              email: $('#email').val(),
              password: $('#password').val()
            },
            function(result) {
              if (result.data == 'yes') {
                $(document).trigger('login.success');
              } else {
                $('#message').text('이메일 또는 암호가 맞지 않습니다.');
              }
            });
      });
      
      $('input').focus(function(event) {
        $('#message').text('');
      }); 
      
    }
  };
});














