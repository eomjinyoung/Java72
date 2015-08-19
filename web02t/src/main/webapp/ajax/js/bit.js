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

var $ = bit;






