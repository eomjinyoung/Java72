require(
  [
      'jquery'
      ,'handlebars'
      ,'jquery.iframe-transport'
      ,'jquery.fileupload'
      ,'bootstrap.min'
      ,'jquery.ui.widget'
  ],
  function($, handlebars) {
    $('#btn1').click(function() {
      var source = $('#template1').html();
      var template = handlebars.compile(source);
      var content = template({});
      
      $('#fileuploadDiv').html(content);
      
      //setupFileUpload();
    });
    
    $('#fileupload').fileupload({
        url: 'server/php/'
    });
    
  }
);
