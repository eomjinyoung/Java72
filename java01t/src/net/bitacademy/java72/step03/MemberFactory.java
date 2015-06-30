package net.bitacademy.java72.step03;

public class MemberFactory {
  // 인스턴스를 만들어주는 메서드를 "팩토리 메서드"라 부른다.
  // GoF => "Design Patterns" => Factory Method Pattern
  public static Member getInstance(
      String name, String id, String password) {
    return new Member().setName(name).setId(id).setPassword(password);
  }
}
