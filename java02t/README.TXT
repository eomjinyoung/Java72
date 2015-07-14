[step01]
1) 일반 프로젝트를 만든다.
2) 그래들 요구에 맞추어 폴더를 생성한다.
3) 프로젝트 설정 파일(.project)에 
   그래들 플러그인 정보를 설정한다.
   => 프로젝트를 다룰 때 어떤 플러그인을 사용할 지 지정한다.
   => 그 정보를 <nature> 태그에 작성해야 한다.
   => 구글링하라! 
4) 일반 프로젝트를 자바 프로젝트로 만들어라!
   => .project의 <natures>안에 
       자바 플러그인 정보를 추가해야 한다. 
   => Gradle을 이용하여 .project 파일을 변경하라!

5) build.gradle 파일에 eclipse 관련 라이브러리를 추가한다.
   => apply plugin: 'eclipse'
6) build.gradle 파일에 java 관련 라이브러리를 추가한다.
   => apply plugin: 'java'   

7) $project -> Run as -> gradle build...
   => eclipse 명령 수행 
   => .project, .classpath, .settings/....jdt 설정파일 생성된다.

[Gradle 명령]
1) 'eclipse' 플러그인
  - eclipseProject : .project 파일 생성
  - eclipseClasspath: .classpath 파일 생성
  - eclipseJdt : '이클립스 자바 플러그인' 설정 파일 생성
  - eclipse : 이클립스 관련 모든 파일 생성

2) 'java' 플러그인
  - compileJava 
    => src/main/java의 소스 파일을 컴파일한다.  
    => build/classes/main 폴더에 클래스 파일을 놓는다.
  - clean
    => build 디렉토리를 삭제한다.
  - processResources
    => src/main/resources의 모든 파일을 
       build/resources/main으로 복사한다. 
  - classes
    => compileJava + processResources
  - compileTestJava
    => compileJava + processResources + classes
    => src/test/java의 소스 파일을 컴파일하여
       build/classes/test에 클래스 파일을 놓는다.
  - processTestResouces
    => src/test/resources의 모든 파일을 
       build/resources/test에 복사한다.
  - jar
    => compileJava + processResources + classes
    => 클래스 파일과 리소스 파일을 
       build/libs/프로젝트명.jar 파일에 묶는다.
  - build
    => compileJava + processResources + ... 작업 수행
    => 자세한 것은 gradle.org의 문서를 참조하라! 

[의존 라이브러리 관리 방법]
       










   







