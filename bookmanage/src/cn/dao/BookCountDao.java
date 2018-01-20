package cn.dao;

import java.util.List;

import cn.model.BookCount;

public interface BookCountDao {
      List<BookCount> selectBookCount();
      int insertBookCount(BookCount bookCount);
}
