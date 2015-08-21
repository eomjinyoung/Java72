
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
});





