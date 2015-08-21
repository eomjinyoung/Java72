var tbody = document.querySelector('#listTable tbody');

var xhr = new XMLHttpRequest();
xhr.onreadystatechange = function() {
  if (xhr.readyState == 4) {
    var result = JSON.parse(xhr.responseText);
    var obj = result.data;
    
    var trList = document.querySelectorAll('.data-row');
    for (var i = 0; i < trList.length; i++) {
      tbody.removeChild(trList[i]); 
    }
    
    var tr, td;
    for (var i in obj) {
      tr = document.createElement('tr');
      tr.className = 'data-row';
      
      td = document.createElement('td');
      td.innerHTML = obj[i].no;
      tr.appendChild(td);
      
      td = document.createElement('td');
      td.innerHTML = 
        '<a href="detail.do?no=' 
        + obj[i].no + '">' 
        + obj[i].title + '</a>';
      tr.appendChild(td);
            
      td = document.createElement('td');
      td.innerHTML = obj[i].createDate;
      tr.appendChild(td);
      
      td = document.createElement('td');
      td.innerHTML = obj[i].viewCount;
      tr.appendChild(td);
      
      tbody.appendChild(tr);
    }
  }
};
xhr.open('GET', 'list.json', true);
xhr.send();








