package net.bitacademy.java72.step07.v06.test05;

// "value" 라는 이름을 가진 속성의 값만 설정할 때는
// 속성 이름을 생략할 수 있다.
// => 다른 이름 안 된다.
//@MyAnno("우헤헤") // 이름을 생략했기 때문에 오류 발생!

// value 이외의 다른 속성 값을 설정하기 때문에 
// value 이름을 생략할 수 없다.
//@MyAnno("값값값...",name="우헤헤") // 오류!
@MyAnno(value="값값값...",name="우헤헤")
public class MyObject {

}








