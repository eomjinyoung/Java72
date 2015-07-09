package net.bitacademy.java72.step07.v04;

import java.util.Map;

public interface Command {
  void execute(Map<String,Object> paramMap);
}
