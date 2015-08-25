/*
 * requirejs 라이브러리의 환경 설정
 */

/*
 * baseUrl: 라이브러리를 찾는 기본 디렉토리
 * paths: 기본 디렉토리 외에 다른 디렉토리의 별명 설정 
 */
requirejs.config({
    baseUrl: 'js',
    paths: {
      'jquery': 'jquery-1.11.3',
      'handlebars': 'handlebars-v3.0.3',
      'jquery.iframe-transport': 'jquery.iframe-transport',
      'jquery.fileupload': 'jquery.fileupload',
      'bootstrap.min': 'bootstrap.min',
      'jquery.ui.widget': 'vendor/jquery.ui.widget'
    }
});

// main.html을 위한 자바스크립트 로딩
requirejs(['main']);








