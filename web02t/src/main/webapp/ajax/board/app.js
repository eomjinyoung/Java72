var tbody = $('#listTable tbody');

$.getJSON('list.json', {name:'okok'}, function(result) {
  $('#pageNo').text(result.pageNo);
  
  var obj = result.data;
  var trList = document.querySelectorAll('.data-row');
  for (var i = 0; i < trList.length; i++) {
    tbody.removeChild(trList[i]); 
  } 
  
  var tr;
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
});





