
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
  
  var prevBtn = document.getElementById('prevBtn');
  var nextBtn = document.getElementById('nextBtn');
  
  // 이전, 다음 버튼 처리
  if (result.pageNo > 1) {
    prevBtn.removeAttribute('disabled');
    prevBtn.href = 'list.do?pageNo=' 
      + (result.pageNo - 1) 
      + '&pageSize=' + result.pageSize; 
  } else {
    prevBtn.setAttribute('disabled', 'disabled');
  }
  
  if (result.isNextPage) {
    nextBtn.removeAttribute('disabled');
    nextBtn.href = 'list.do?pageNo=' 
      + (result.pageNo + 1) 
      + '&pageSize=' + result.pageSize;
  } else {
    nextBtn.setAttribute('disabled', 'disabled');
  }
  
  prevBtn.onclick = function(event) {
    event.preventDefault();
  };
  
  nextBtn.onclick = function(event) {
    event.preventDefault();
  };
});


  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  




