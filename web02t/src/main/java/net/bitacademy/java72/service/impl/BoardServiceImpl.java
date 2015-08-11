package net.bitacademy.java72.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.bitacademy.java72.dao.BoardDao;
import net.bitacademy.java72.domain.Board;
import net.bitacademy.java72.service.BoardService;

@Service
public class BoardServiceImpl implements BoardService {
  @Autowired BoardDao boardDao;
  
  @Override
  public List<Board> list() {
    return boardDao.list();
  }

  @Override
  public int delete(int no) {
    return boardDao.delete(no);
  }

  @Override
  public int update(Board board) {
    return boardDao.update(board);
  }

  @Override
  public int insert(Board board) {
    return boardDao.insert(board);
  }

  @Override
  public Board get(int no) {
    return boardDao.get(no);
  }

}
