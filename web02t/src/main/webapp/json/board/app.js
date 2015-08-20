var currPageNo = 1;
var pageSize = 3;

listBoard(currPageNo, pageSize);

var prevBtn = $('#prevBtn');
var nextBtn = $('#nextBtn');

prevBtn.click(function(event) {
  event.preventDefault();
  if (this.getAttribute('disabled') == 'disabled') {
    return;
  }

  //이전 페이지 목록 가져오기
  listBoard(currPageNo - 1, pageSize);
});

nextBtn.click(function(event) {
  event.preventDefault();
  if (this.getAttribute('disabled') == 'disabled') {
    return;
  }
  //다음 페이지 목록 가져오기
  listBoard(currPageNo + 1, pageSize);
});

function listBoard(pageNo, pageSize) {
  $.getJSON('list.do', 
    {
      pageNo: pageNo,
      pageSize: pageSize,
    }, 
    function(result) {
      window.currPageNo = result.pageNo;
      $('#pageNo').text(currPageNo);
      
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
        $('<td>').text(obj[i].yyyyMMdd).appendTo(tr);
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
}


  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  




