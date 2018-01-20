package cn.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import cn.dao.UserDao;
import cn.db.DBConection;
import cn.model.User;

public class UserImpl extends DBConection implements UserDao {

	
	public User selectId(User user){
		User us =new User();
		Connection conn=null;
		PreparedStatement pre=null;
		ResultSet res=null;
		conn=getConnection();
		
		try {
			String sql="select * from user where username=?";
			pre=conn.prepareStatement(sql);
			pre.setString(1, user.getUserName());
	        res=pre.executeQuery();
	        while(res.next()){
	        	 us.setId(res.getInt("id"));
				 
	        }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return us;
		
	}
	
	@Override
	public User selectOne(User user) {
		// TODO Auto-generated method stub
		Connection conn=null;
		PreparedStatement pre=null;
		ResultSet res=null;
		conn=getConnection();
		User u= new User(); 
		try {
			String sql="select * from user where username=? and password=? ";
			pre=conn.prepareStatement(sql);
			pre.setString(1, user.getUserName());
			pre.setString(2, user.getPassword());
			
			res=pre.executeQuery();
			while(res.next()){
				   u.setId(res.getInt("id"));
				   u.setUserName(res.getString("username"));
				   u.setPassword(res.getString("password"));
				   u.setIsLeader(res.getInt("isLeader"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			closeAll(res, pre, conn);
		}
		
		
		return u;
	}

	@Override
	public double selectMoney(User user) {
		// TODO Auto-generated method stub
		Connection conn=null;
		PreparedStatement pre= null;
		ResultSet res= null;
		conn=getConnection();
		double money=0.0;
		
		 
         try {
        	 String sql = "select money  from user where isleader=? and username=?";
			 pre=conn.prepareStatement(sql);
			 pre.setInt(1, user.getIsLeader());
			 pre.setString(2, user.getUserName());
			 res=pre.executeQuery();
			 while(res.next()){
				money=res.getDouble("money");
			 }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return money;
	}
	public double selectUserMoney(User user) {
		// TODO Auto-generated method stub
		Connection conn=null;
		PreparedStatement pre= null;
		ResultSet res= null;
		conn=getConnection();
		double money=0.0;
		User u= new User();
		
         try {
        	 String sql = "select money  from user where id=?";
			 pre=conn.prepareStatement(sql);
			 pre.setInt(1, user.getId());
			 res=pre.executeQuery();
			 while(res.next()){
				money=res.getDouble("money");
			 }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return money;
	}
	@Override
	public int insertUser(User user) {
		// TODO Auto-generated method stub
		Connection conn=null;
		int num=0;
		conn=getConnection();
		String sql="insert into user(username,password,money,isLeader)value(?,?,?,?)";
		Object [] objects={user.getUserName(),user.getPassword(),user.getMoney(),user.getIsLeader()};
		num=executeUpdate(sql, objects);
		return num;
	}

	@Override
	public int updateUser(User user) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteUser(User user) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateMoney(User user) {
		// TODO Auto-generated method stub
		
		Connection conn=null;
		int num=0;
		conn=getConnection();
		String sql="update user set money=? where isLeader=? and username=?";
		
		Object [] objects={user.getMoney(),user.getIsLeader(),user.getUserName()};
		num=executeUpdate(sql, objects);
		return num;
	}
	public int updateUserMoney(User user) {
		// TODO Auto-generated method stub
		
		Connection conn=null;
		int num=0;
		conn=getConnection();
		String sql="update user set money=? where isLeader=?  and id=?";
		
		Object [] objects={user.getMoney(),user.getIsLeader(),user.getId()};
		num=executeUpdate(sql, objects);
		return num;
	}
}
