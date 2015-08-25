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
        'jquery': 'lib/jquery-1.11.3',
        'bootstrap': 'lib/bootstrap.min',
        'handlebars': 'lib/handlebars-v3.0.3',
        'jquery.ui.widget': 'lib/vendor/jquery.ui.widget',
        'load-image.all.min': 'lib/load-image.all.min',
        'canvas-to-blob.min': 'lib/canvas-to-blob.min',
        'jquery.iframe-transport': 'lib/jquery.iframe-transport',
        'jquery.fileupload': 'lib/jquery.fileupload',
        'jquery.fileupload-process': 'lib/jquery.fileupload-process',
        'jquery.fileupload-image': 'lib/jquery.fileupload-image',
        'jquery.fileupload-audio': 'lib/jquery.fileupload-audio',
        'jquery.fileupload-video': 'lib/jquery.fileupload-video',
        'jquery.fileupload-validate': 'lib/jquery.fileupload-validate',
        'bootstrap.min': 'lib/bootstrap.min'
    }
});

// main.html을 위한 자바스크립트 로딩
requirejs(['app/main']);








