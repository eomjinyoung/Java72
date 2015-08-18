package net.bitacademy.java72.dao;

import java.util.List;
import java.util.Map;

import net.bitacademy.java72.domain.Board;

public interface BoardDao {
  List<Board> list(Map<String,Object> paramMap);
  int delete(int no);
  int update(Board board);
  int insert(Board board);
  Board get(int no);
  int countAll();
}











