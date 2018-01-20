package cn.impl;

import java.sql.Connection;
import java.util.List;

import cn.dao.BookCountDao;
import cn.db.DBConection;
import cn.model.BookCount;

public class BookCountImpl extends DBConection implements BookCountDao {

	@Override
	public List<BookCount> selectBookCount() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int insertBookCount(BookCount bookCount) {
		// TODO Auto-generated method stub
		
		int num=0;
		Connection conn=null;
		conn=getConnection();
		String sql="insert into bookcount(uid,bookname,sellnumber,sellprice,selldate)value(?,?,?,?,?)";
		Object [] objects={bookCount.getUid(),bookCount.getBookName(),bookCount.getSellNumber(),bookCount.getSellPrice(),bookCount.getSellDate()};
		num=executeUpdate(sql, objects);
		return num;
	}

}
