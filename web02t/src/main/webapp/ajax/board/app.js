var tbody = $('#listTable tbody');

var xhr = new XMLHttpRequest();
xhr.onreadystatechange = function() {
  if (xhr.readyState == 4) {
    var result = JSON.parse(xhr.responseText);

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
  }
};
xhr.open('GET', 'list.json', true);
xhr.send();








