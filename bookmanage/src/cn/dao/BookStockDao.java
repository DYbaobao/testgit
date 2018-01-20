package cn.dao;

import java.util.List;

import cn.model.BookStock;

public interface BookStockDao {
     List<BookStock> selectBookStock(BookStock bookStock);
     int insertBooksStock(BookStock bookStock);
     int deleteBooksStock(BookStock bookStock);
     BookStock selectBookPrice(BookStock bookStock);
     int selectBookNumber(BookStock bookStock);
     int  updateBookPrice(BookStock bookStock);
     int updateBookNumber(BookStock bookStock);
}
