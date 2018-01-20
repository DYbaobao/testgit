package cn.impl;

import java.sql.Connection;
import java.util.List;

import cn.dao.UserStockDao;
import cn.db.DBConection;
import cn.model.UserStock;

public class UserStockImpl extends DBConection implements UserStockDao {

	@Override
	public int insertBooks(UserStock userStock) {
		// TODO Auto-generated method stub
		int num=0;
		Connection conn=null;
		conn=getConnection();
		String sql="insert into userstock(uid,bookname,buydate,buynumber,bookprice) value(?,?,?,?,?)";
		Object [] objects ={userStock.getUId(),userStock.getBookName(),userStock.getBuyDate(),userStock.getBuyNumber(),userStock.getBookPrice()};
		num=executeUpdate(sql, objects);
		return num;
	}

	@Override
	public List<UserStock> selectUserStock(UserStock userStock) {
		// TODO Auto-generated method stub
		return null;
	}

}
