package net.bitacademy.java72.step07.v06;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* 애노테이션?
 * - 컴파일러나 JVM에게 전달하는 아주 특별한 주석
 * - 보통 일반적인 주석은(//, / * * /) 컴파일할 때 제거된다.
 *   즉, 클래스 파일에 남아있지 않다.
 * - 애노테이션은 컴파일 한 후에도 클래스 파일에 남아있게 
 *   할 수 있다.
 * - 그래서 실행 중에 클래스 파일에 있는 주석을 꺼낼 수 있다.
 * - 애노테이션은 구조화된 정보를 전달 할 수 있다.
 */
@Retention(RetentionPolicy.RUNTIME)
public @interface CommandProcessor {
  String value(); // 처리할 명령어 이름은 필수 값이
}











