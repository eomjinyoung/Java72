package net.bitacademy.java72.dao;

import java.util.List;

import net.bitacademy.java72.domain.Board;

public interface BoardDao {
  List<Board> list();
  int delete(int no);
  int update(Board board);
  int insert(Board board);
  Board get(int no);
}











