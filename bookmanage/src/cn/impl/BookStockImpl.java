package cn.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import cn.dao.BookStockDao;
import cn.db.DBConection;
import cn.model.BookStock;
import cn.model.ShoppingCart;
import cn.model.User;

public class BookStockImpl extends DBConection implements BookStockDao {
	public List<BookStock> selectPageAll(int currPageNo,int pageSize) {
		Connection conn=null;
		PreparedStatement pre= null;
		ResultSet res=null;
 	
 		BookStock bStock =null;
 		List<BookStock> bookStocks=null;
 		conn=getConnection();	
 		try {
 			String sql="select * from bookstock limit ?,?";
 			pre=conn.prepareStatement(sql);	
 			pre.setInt(1, (currPageNo-1)*pageSize);
 			pre.setInt(2, pageSize);
 			res=pre.executeQuery();
 		   bookStocks=new ArrayList<BookStock>();
 			while(res.next()){
 				bStock=new BookStock();
 				bStock.setId(res.getInt("id"));
 				bStock.setBookName(res.getString("bookName"));
 				bStock.setBookContent(res.getString("bookContent"));
 				bStock.setPublisher(res.getString("publisher"));
 				bStock.setPublishingDate(res.getObject("publishingDate"));
 				bStock.setAddDate(res.getObject("adddDate"));
 				bStock.setBookPrice(res.getDouble("bookPrice"));
 				bStock.setBookNumber(res.getInt("bookNumber"));
 				bookStocks.add(bStock);
 			}
 		} catch (SQLException e) {
 			e.printStackTrace();
 		}finally{
 			closeAll(res, pre, conn);
 		}
 		
 		return bookStocks;
 	}
    public int  selectBookStock(){
    	int num=0;
    	 Connection conn=null;
		 PreparedStatement pre=null;
		 ResultSet res=null;
		 conn=getConnection();
		 
		 try {
			 String sql= "select conut(1) from bookstock";
			pre =conn.prepareStatement(sql);
			res=pre.executeQuery();
			while(res.next()){
				num=res.getInt(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			closeAll(res, pre, conn);
		}
    	return num;
    }
	@Override
	public List<BookStock> selectBookStock(BookStock bookStock) {
		// TODO Auto-generated method stub
		ArrayList<BookStock> bookStocks=new ArrayList<BookStock>();
		 Connection conn=null;
		 PreparedStatement pre=null;
		 ResultSet res=null;
		 conn=getConnection();
		 
		 try {
			 String sql="select * from bookstock where bookname like ?";
			 pre=conn.prepareStatement(sql);
			 pre.setString(1, "%"+bookStock.getBookName()+"%");
			 res=pre.executeQuery();
			 while(res.next()){
				 BookStock bStock =new BookStock();
				 bStock.setId(res.getInt("id"));
				 bStock.setBookName(res.getString("bookname"));
				 bStock.setBookContent(res.getString("bookcontent"));
				 bStock.setPublisher(res.getString("publisher"));
				 bStock.setPublishingDate(res.getObject("publishingdate"));
				 bStock.setAddDate(res.getObject("adddate"));
				 bStock.setBookPrice(res.getDouble("bookprice"));
				 bStock.setBookNumber(res.getInt("booknumber"));
				 bookStocks.add(bStock);
			 }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			closeAll(res, pre, conn);
		}
		return bookStocks;
	}

	
	public List<BookStock> selectBookStockAll() {
		// TODO Auto-generated method stub
		ArrayList<BookStock> bookStocks=new ArrayList<BookStock>();
		 Connection conn=null;
		 PreparedStatement pre=null;
		 ResultSet res=null;
		 conn=getConnection();
		 
		 try {
			 String sql="select * from bookstock ";
			 pre=conn.prepareStatement(sql);
			
			 res=pre.executeQuery();
			 while(res.next()){
				 BookStock bStock =new BookStock();
				 bStock.setId(res.getInt("id"));
				 bStock.setBookName(res.getString("bookname"));
				 bStock.setBookContent(res.getString("bookcontent"));
				 bStock.setPublisher(res.getString("publisher"));
				 bStock.setPublishingDate(res.getObject("publishingdate"));
				 bStock.setAddDate(res.getObject("adddate"));
				 bStock.setBookPrice(res.getDouble("bookprice"));
				 bStock.setBookNumber(res.getInt("booknumber"));
				 bookStocks.add(bStock);
			 }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			closeAll(res, pre, conn);
		}
		return bookStocks;
	}
	
	
	@Override
	public int insertBooksStock(BookStock bookStock) {
		// TODO Auto-generated method stub
		int num=0;
		Connection conn=null;
		conn=getConnection();
		String sql="insert into bookstock(bookname,bookcontent,publisher,publishingdate,adddate,bookprice,booknumber)value(?,?,?,?,?,?,?)";
		Object [] objects={bookStock.getBookName(),bookStock.getBookContent(),bookStock.getPublisher(),bookStock.getPublishingDate(),bookStock.getAddDate(),bookStock.getBookPrice(),bookStock.getBookNumber()};
		num=executeUpdate(sql, objects);
		return num;
	}

	@Override
	public int deleteBooksStock(BookStock bookStock) {
		// TODO Auto-generated method stub
		int num=0;
		Connection conn=null;
		conn=getConnection();
		String sql="delete from bookstock where id=?";
		Object [] objects ={bookStock.getId()};
		num=executeUpdate(sql, objects);
		return num;
	}

	@Override
	public BookStock selectBookPrice(BookStock bookStock) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int selectBookNumber(BookStock bookStock) {
		// TODO Auto-generated method stub
		 ShoppingCart sCart =new ShoppingCart();
		  Connection conn= null;
		  PreparedStatement pre= null;
		  ResultSet res=null;
		  int number=0;
		  conn=getConnection();
		 
		  try {
			  String sql="select booknumber from bookStock   where id=?";
			  pre=conn.prepareStatement(sql);
			  pre.setInt(1, bookStock.getId());
			  res=pre.executeQuery();
			  while(res.next()){
				  number=res.getInt("booknumber");
			  }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return number;
	}

	@Override
	public int updateBookPrice(BookStock bookStock) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateBookNumber(BookStock bookStock) {
		// TODO Auto-generated method stub
		int num=0;
		Connection conn=null;
		conn=getConnection();
		String sql="update bookstock set booknumber=? where id=?";
		Object [] objects ={bookStock.getBookNumber(),bookStock.getId()};
		num=executeUpdate(sql, objects);
		return num;
	}

}
