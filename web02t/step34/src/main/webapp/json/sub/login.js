//사용자 정보 감추기
$('#userInfo').css('display', 'none');

//로그인 정보 가져오기
$.getJSON(contextRoot + '/json/auth/loginInfo.do', function(result) {
  if (result.state == 'yes') {  
    $('#userName').text(result.data.name);
    $('#userEmail').text(result.data.email);
    $('#loginBtn').css('display', 'none');
    $('#userInfo').css('display', '');
  }
});

$('#loginBtn').click(function(event) {
  event.preventDefault();
  $.getJSON(contextRoot + '/json/auth/setRefererUrl.do', 
    {refererUrl: encodeURIComponent(location.href)},
    function(result) {
      location.href = contextRoot + '/json/auth/index.html';
  });
});
  
$('#logoutBtn').click(function(event) {
  event.preventDefault();
  $.getJSON(contextRoot + '/json/auth/logout.do', function(result) {
    location.href = contextRoot + '/json/auth/index.html';
  });
});
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  




