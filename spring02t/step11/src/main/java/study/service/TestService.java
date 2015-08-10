package study.service;

import study.vo.Test01;
import study.vo.Test02;

public interface TestService {
  void addTest(Test01 test01, Test02 test02) throws Exception;
  void m1(Test01 test01) throws Exception;
  void m2(Test02 test02) throws Exception;
}
