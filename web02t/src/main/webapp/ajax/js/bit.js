function bit(value) {
  var obj;
  if (value.charAt(0) == '<') {
    obj = [document.createElement(
        value.substring(1, value.length - 1))];
  } else {
    obj = [document.querySelector(value)];
  }
  
  obj.html = function(content) {
    this[0].innerHTML = content;
    return this;
  };
  
  obj.text = function(content) {
    this[0].textContent = content;
    return this;
  };
  
  obj.addClass = function(className) {
    if (this[0].className != '')
      this[0].className = '';
    this[0].className += ' ' + className;
    return this;
  };
  
  obj.append = function(child) {
    this[0].appendChild(child[0]);
    return this;
  };
  
  obj.appendTo = function(parent) {
    parent[0].appendChild(this[0]);
    return this;
  };
  
  obj.attr = function(attrName, value) {
    this[0].setAttribute(attrName, value);
    return this;
  };
  
  return obj;
} 
bit.toQueryString = function(obj) {
  if (obj == null || obj == undefined) {
    return null;
  }
  
  var queryString = '';
  for (var propName in settings.data) {
    if (queryString.length > 0) {
      queryString += '&';
    }
    queryString += propName 
      + '=' 
      + encodeURIComponent(settings.data[propName]);
  }
  return queryString;
};

bit.ajax = function(url, settings) {
  var xhr = new XMLHttpRequest();
  xhr.onreadystatechange = function() {
    if (xhr.readyState == 4) {
      if (settings.dataType == 'json') {
        settings.success(JSON.parse(xhr.responseText));
      } else {
        settings.success(xhr.responseText);
      }
    }
  };
  
  var method = settings.method.toLowerCase(); 
  if (method == 'get') {
    var queryString = bit.toQueryString(settings.data);
    if (queryString != null) {
      url += '?' + queryString;
    }
    xhr.open(settings.method, url, true);
    xhr.send();
    
  } else if (method == 'post') {
    xhr.open(settings.method, url, true);
    xhr.setRequestHeader('Content-type', 
              'application/x-www-form-urlencoded');
    xhr.send(bit.toQueryString(settings.data));
  }
};

var $ = bit;






