package net.bitacademy.java72.service;

import java.util.List;

import net.bitacademy.java72.domain.Board;

public interface BoardService {
  List<Board> list(int pageNo, int pageSize);
  int delete(int no);
  int update(Board board);
  int insert(Board board);
  Board get(int no);
  int countAll();
}







