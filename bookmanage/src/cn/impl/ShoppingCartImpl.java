package cn.impl;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import cn.dao.ShoppingCartDao;
import cn.db.DBConection;
import cn.model.ShoppingCart;

public class ShoppingCartImpl extends DBConection implements ShoppingCartDao {

	@Override
	public List<ShoppingCart> selectShoppingCart(ShoppingCart shoppingCart) {
		// TODO Auto-generated method stub
		ArrayList<ShoppingCart> shoppingCarts = new ArrayList<ShoppingCart>();
		Connection conn=null;
		PreparedStatement pre= null;
		ResultSet res=null;
		conn=getConnection();
		
		try {
			String sql="select * from shoppingcart where uid=?";
			pre=conn.prepareStatement(sql);
			pre.setInt(1, shoppingCart.getUId());
			res=pre.executeQuery();
			while(res.next()){
				ShoppingCart sCart = new ShoppingCart();
				sCart.setScId(res.getInt("scid"));
				sCart.setPrice(res.getDouble("price"));
				sCart.setNumber(res.getInt("number"));
				sCart.setBookName(res.getString("bookName"));
				sCart.setAddDate(res.getObject("adddate"));
				sCart.setPublisher(res.getString("publisher"));
				sCart.setPublishingDate(res.getObject("publishingdate"));
				shoppingCarts.add(sCart);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return shoppingCarts;
	}

	@Override
	public int insertShoppingCart(ShoppingCart shoppingCart) {
		// TODO Auto-generated method stub
		int num=0;
		Connection conn=null;
		conn=getConnection();
		String sql="insert into shoppingcart(uid,price,number,bookname,adddate,publisher,publishingdate,summoney)values(?,?,?,?,?,?,?,?)";
		Object [] objects ={shoppingCart.getUId(),shoppingCart.getPrice(),shoppingCart.getNumber(),shoppingCart.getBookName(),shoppingCart.getAddDate(),shoppingCart.getPublisher(),shoppingCart.getPublishingDate(),shoppingCart.getSumMoney()};
		num=executeUpdate(sql, objects);
		return num;
	}

	@Override
	public int deleteShoppingCatt(ShoppingCart shoppingCart) {
		// TODO Auto-generated method stub
		 int num=0;
		 Connection conn=null;
		 conn=getConnection();
		 String sql="delete from shoppingcart where scid=?";
		 Object []  objects={shoppingCart.getScId()};
		 num=executeUpdate(sql, objects);
		return num;
	}

	@Override
	public double selectShoppingCartPrice(ShoppingCart shoppingCart) {
		// TODO Auto-generated method stub
		 ShoppingCart sCart = new ShoppingCart();
		  Connection conn= null;
		  PreparedStatement pre= null;
		  ResultSet res=null;
		  double summoney=0.0;
		  conn=getConnection();
		
		  try {
			  String sql="select summoney from shoppingcart where scid=?";
			  pre=conn.prepareStatement(sql);
			  pre.setInt(1, shoppingCart.getScId());
			  res=pre.executeQuery();
			  while(res.next()){
				  summoney=res.getDouble("summoney");
			  }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return summoney;
	}

	@Override
	public int selectShoppingCartNumber(ShoppingCart shoppingCart) {
		// TODO Auto-generated method stub
		 ShoppingCart sCart =new ShoppingCart();
		  Connection conn= null;
		  PreparedStatement pre= null;
		  ResultSet res=null;
		  int number=0;
		  conn=getConnection();
		 
		  try {
			  String sql="select number from shoppingcart where scid=?";
			  pre=conn.prepareStatement(sql);
			  pre.setInt(1, shoppingCart.getScId());
			  res=pre.executeQuery();
			  while(res.next()){
				  number=res.getInt("number");
			  }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return number;
	}

	@Override
	public int updateShoppingCartNumber(ShoppingCart shoppingCart) {
		// TODO Auto-generated method stub
		return 0;
	}

}
