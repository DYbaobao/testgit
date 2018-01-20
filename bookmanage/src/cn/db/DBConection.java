package cn.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBConection {
	
		static Connection conn = null;
		static PreparedStatement pre=null;
		static ResultSet res=null;
		public  Connection getConnection(){
			try {
				Class.forName("com.mysql.jdbc.Driver");
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			String url = "jdbc:mysql://localhost:3306/bookmanage" ;   
	   	 String username = "root" ;
	   	  String password = "2009" ;
			try {
				conn=DriverManager.getConnection(url,username,password);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return conn;
		}
		public  void closeAll(ResultSet res,PreparedStatement pre,Connection conn){
			if(res!=null){
				try {
					res.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(pre!=null){
				try {
					pre.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			if(conn!=null){
				try {
					conn.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
		public  int executeUpdate(String sql,Object[] objects){
			int num=0;
			
			 conn=getConnection();
			 try {
				pre=conn.prepareStatement(sql);
				 
				if(objects!=null&&objects.length>0){
					for (int i = 0; i < objects.length; i++) {
							pre.setObject((i+1),objects[i]);
				   }
				}
				num=pre.executeUpdate();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally{
				closeAll(res,pre,null);
			}
			
			return num;
		}
}
