[Gradle 프로젝트 만들기]
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
1) 의존 라이브러리를 다운로드 받을 서버를 지정한다.
repositories {
  mavenCentral() // https://repo1.maven.org/maven2/
}       

2) 가져올 라이브러리를 지정한다.
=> 라이브러리 검색: www.mvnrepository.com
dependencies {
  // 문법1
  라이브러리관리정책(ex:compile, testCompile, providedCompild,...)  
    group: '그룹명', 
    name: '라이브러리명',
    version: '버전'
  // 문법2
  compile '그룹명:라이브러리명:버전'
  
  //예) 
  compile 
        group: 'org.hibernate', 
        name: 'hibernate-core', 
        version: '3.6.7.Final'
  compile 'org.hibernate:hibernate-core:3.6.7.Final'
}
=> 라이브러리 관리 정책
  - compile: 컴파일할 때 사용하고 또한 배치 파일에 포함하라.
  - testCompile: 단위 테스트를 실행할 때 사용하는 라이브러리.
  - providedCompile: 컴파일 할 때 사용, 배치에서 제외.

[step01]
- java01 프로젝트에 만든 프로그래밍을 그래들 프로젝트로 포팅.
- 각 클래스를 의미있는 패키지로 분류한다.
  control : 명령어를 처리하는 클래스를 두는 패키지
  dao: DAO를 두는 패키지
  domain: VO를 두는 패키지
- mybatis 관련 XML 파일은 resources 폴더에 둔다.
  src/main/resources/net/bitacademy/java72/dao 폴더에 복사한다. 
- mybatis-config.xml 변경
- BoardDao.xml과 MemberDao.xml의 네임스페이스 값 변경.
- BoardDao.java와 MemberDao.java 변경
  => 클래스 패키지 import.
  => SQL 아이디를 변경한다.  
- MainApp.java를 변경한다.
  => 클래스를 찾아서 객체를 생성하는 코드 부분.
     패키지 이름을 변경한다.
- 자바 소스 파일이 어떤 문자 집합으로 인코딩되었는지 
  설정한다.
       
[step02]
- 배치 파일 만들기
  => 사용자가 실행할 수 있도록 클래스 파일을 묶어
     .jar 파일을 만든다.
- jar 파일 실행
  java -jar jar파일명
  => JVM은 jar파일에서 META-INF/MANIFEST.MF 파일을 읽는다.
  => main 메서드를 갖고 있는 클래스를 찾아서 실행한다.
  => 만약 메인 클래스를 찾지 못하면 오류 발생!
- jar 파일을 만들 때 어떤 클래스가 main() 를 갖고 있는 
  클래스인지 설정한다.
  또한 의존 라이브러리 파일도 jar 파일에 포함시킨다.
// jar 파일 설정
jar {
  manifest {
     attributes 'Main-Class': 'net.bitacademy.java72.MainApp'
  }
  from { // 의존 라이브러리 파일을 jar 파일에 통합하라!
    configurations.compile.collect { it.isDirectory() ? it : zipTree(it) }
  }
} 
       
[step03]
- 스프링 프레임워크를 이용한 빈 관리하기 
1) 스프링 프레임워크 라이브러리 추가 





   







