[Gracle 웹 프로젝트 만들기]
1. web02t 프로젝트 생성
2. src 폴더 생성
3. src/main/webapp 폴더 추가
   => 웹 애플리케이션 관련 파일을 두는 폴더
4. build.gradle 파일 준비
5. .project에 gradle 네이처 추가
6. 기본 이클립스 관련 설정 파일 생성
   => Run As -> build... -> clean, eclipse
   
[톰캣 테스트 서버에 자동 배치할 수 있도록 웹 프로젝트 설정]
1. build.gradle에 웹 관련 플러그인 추가
   => apply plugin: 'war'
   => apply plugin: 'eclipse-wtp'
   => 웹 관련 설정 파일을 만들 수 있는 명령을 사용할 수 있다.
      
   
   
   
   
   
   
   
   
   