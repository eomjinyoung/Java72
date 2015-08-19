function bit(value) {
  var obj;
  if (value.charAt(0) == '<') {
    obj = [document.createElement(
        value.substring(1, value.length - 1))];
  } else {
    var el = document.querySelectorAll(value); 
    obj = [];
    for (var i = 0; i < el.length; i++) {
      obj[i] = el[i]; 
    }
  }
  
  obj.html = function(content) {
    for (var i = 0; i < this.length; i++) {
      this[i].innerHTML = content;
    }
    return this;
  };
  
  obj.text = function(content) {
    for (var i = 0; i < this.length; i++) {
      this[i].textContent = content;
    }
    return this;
  };
  
  obj.addClass = function(className) {
    for (var i = 0; i < this.length; i++) {
      if (this[i].className != '')
        this[i].className = '';
      this[i].className += ' ' + className;
    }
    return this;
  };
  
  obj.append = function(child) {
    for (var i = 0; i < this.length; i++) {
      for (var j = 0; j < child.length; j++) {
        this[i].appendChild(child[j]);
      }
    }
    return this;
  };
  
  obj.appendTo = function(parent) {
    parent.append(this);
    return this;
  };
  
  obj.attr = function(attrName, value) {
    for (var i = 0; i < this.length; i++) {
      this[i].setAttribute(attrName, value);
    }
    return this;
  };
  
  obj.remove = function() {
    for (var i = 0; i < this.length; i++) {
      this[i].parentElement.removeChild(this[i]);
    }
    return this;
  };
  
  obj.removeAttr = function(attrName) {
    for (var i = 0; i < this.length; i++) {
      this[i].removeAttribute(attrName);
    }
    return this;
  };
  
  obj.click = function(listener) {
    for (var i = 0; i < this.length; i++) {
      if (this[i].addEventListener) {//크롬,사파리,파폭,IE >= 9
        this[i].addEventListener('click', listener);
      } else { // IE <= 8
        this[i].attachEvent('onclick', listener);
      }
    }
    return this;
  };
  
  
  return obj;
} 

bit.getXMLHttpRequest = function() {
  var xhr = null;
  if (window.XMLHttpRequest || window.ActiveXObject) {
     if (window.ActiveXObject) {
        try {
           xhr = new ActiveXObject("Msxml2.XMLHTTP");
        } catch(e) {
           xhr = new ActiveXObject("Microsoft.XMLHTTP");
        }
     } else {
        xhr = new XMLHttpRequest();
     }
  } else {
     alert("Your browser doesn't support XMLHTTPRequest...");
     return null;
  }
  return xhr;
};

bit.toQueryString = function(obj) {
  if (obj == null || obj == undefined) {
    return null;
  }
  
  var queryString = '';
  for (var propName in obj) {
    if (queryString.length > 0) {
      queryString += '&';
    }
    queryString += propName 
      + '=' 
      + encodeURIComponent(obj[propName]);
  }
  return queryString;
};

bit.ajax = function(url, settings) {
  var xhr = bit.getXMLHttpRequest();
  xhr.onreadystatechange = function() {
    if (xhr.readyState == 4 && settings.success) {
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

bit.getJSON = function(url, arg1, arg2) {
  var settings = {
      method: 'GET',
      dataType: 'json'
  };
  
  if (arguments.length == 3) {
    settings.data = arg1;
    settings.success = arg2;
    bit.ajax(url, settings);
    
  } else if (arguments.length == 2) {
    if (typeof arg1 == 'function') {
      settings.success = arg1;
    } else {
      settings.data = arg1;
    }
    bit.ajax(url, settings);
  }
}

var $ = bit;










