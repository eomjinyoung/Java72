//사용자 정보 감추기
$('#userInfo').css('display', 'none');

loadLoginInfo();

//로그인 정보 가져오기
function loadLoginInfo() {
  $.getJSON(contextRoot + '/json/auth/loginInfo.do', function(result) {
    if (result.state == 'yes') {  
      $('#userName').text(result.data.name);
      $('#userEmail').text(result.data.email);
      $('#loginBtn').css('display', 'none');
      $('#userInfo').css('display', '');
    } else {
      $('#loginBtn').css('display', '');
      $('#userInfo').css('display', 'none');
    }
  });
}

$('#loginBtn').click(function(event) {
  event.preventDefault();
  $('#content').load('sub/auth.html');
});
  
$('#logoutBtn').click(function(event) {
  event.preventDefault();
  $.getJSON(contextRoot + '/json/auth/logout.do', function(result) {
    $(document).trigger('logout.success');
  });
});
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  




