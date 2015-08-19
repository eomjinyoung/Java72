var prevBtn = $('#prevBtn');
var nextBtn = $('#nextBtn');
  
prevBtn.click(function(event) {
  event.preventDefault();
  alert('이전');
});

nextBtn.click(function(event) {
  event.preventDefault();
  alert('다음');
});
  
$.getJSON('list.json', function(result) {
  $('#pageNo').text(result.pageNo);
  
  var tbody = $('#listTable tbody');
  $('.data-row').remove();
  
  var tr;
  var obj = result.data;
  for (var i in obj) {
    tr = $('<tr>').addClass('data-row').appendTo(tbody);
    $('<td>').text(obj[i].no).appendTo(tr);
    $('<td>').append($('<a>')
                .attr('href', 'detail.do?no=' + obj[i].no)
                .text(obj[i].title))
             .appendTo(tr);
    $('<td>').text(obj[i].createDate).appendTo(tr);
    $('<td>').text(obj[i].viewCount).appendTo(tr);
  }
  
  // 이전, 다음 버튼 처리
  if (result.pageNo > 1) {
    prevBtn.removeAttr('disabled');
    prevBtn.attr('href', 'list.do?pageNo=' 
      + (result.pageNo - 1) 
      + '&pageSize=' + result.pageSize); 
  } else {
    prevBtn.attr('disabled', 'disabled');
  }
  
  if (result.isNextPage) {
    nextBtn.removeAttr('disabled');
    nextBtn.attr('href', 'list.do?pageNo=' 
      + (result.pageNo + 1) 
      + '&pageSize=' + result.pageSize);
  } else {
    nextBtn.attr('disabled', 'disabled');
  }
  
  
});


  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  




