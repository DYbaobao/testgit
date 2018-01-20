package cn.manager;

import java.util.Date;

import cn.impl.BookCountImpl;
import cn.impl.BookStockImpl;
import cn.impl.ShoppingCartImpl;
import cn.impl.UserImpl;
import cn.impl.UserStockImpl;
import cn.model.BookCount;
import cn.model.BookStock;
import cn.model.ShoppingCart;
import cn.model.User;
import cn.model.UserStock;

public class PayMoneyManager {
	
	
	
	 /*  private int id;
        public int getId() {
			return id;
		 }
		public void setId(int id) {
			this.id = id;
		}*/
	  double sumMoney=0.0;
	  double userMoney=0.0;
	  double money=0.0;
	  double addMoney=0.0;
	  double removeMoney=0.0;
	  int numbers=0;
	  int removenumber=0;
	       ShoppingCartImpl shoppingCartImpl= new ShoppingCartImpl();
	       ShoppingCart shoppingCart = new ShoppingCart();
	       ShoppingCart sCart = new ShoppingCart();
	         User user =new User();
	         UserImpl userImpl= new UserImpl();
			BookStockImpl bookStockImpl= new BookStockImpl();
			BookStock bookStock= new BookStock();
			UserStock userStock = new UserStock();
			UserStockImpl userStockImpl = new UserStockImpl();
			BookCount bookCount = new BookCount();
			BookCountImpl bookCountImpl = new BookCountImpl();
		public double selectSumMoney(int id){
        	  double summoney=0.0;
        	   shoppingCart.setScId(id);
        	   summoney=shoppingCartImpl.selectShoppingCartPrice(shoppingCart);
        	  return  summoney;
          }
          public double selectMoney(){
        	  user.setIsLeader(1);
        	  user.setUserName("tom");
        	  double money=userImpl.selectMoney(user);
			  return money;
        	
          }
          
          public double selectUserMoney(int id){
        	  double money=0.0;
        	  int isd=id;
        	  user.setId(isd);
        	  money=userImpl.selectUserMoney(user);
        	  return money;
          }
          public Boolean payMoney(int id,int uid){
        	  Boolean rBoolean =false;
        	  int isd=id;
        	    sumMoney=selectSumMoney (isd);
        	    money=selectMoney();
        	   int idr=uid;
        	    userMoney=selectUserMoney(idr);
			   addMoney=money+sumMoney;
			   user.setMoney(addMoney);
			   user.setIsLeader(1);
			   user.setUserName("tom");
			   int num=userImpl.updateMoney(user);
			   if(num>0){
				   rBoolean=true;
			   }
			  removeMoney=userMoney-sumMoney;
			   user.setMoney(removeMoney);
			   user.setIsLeader(0);
			   user.setId(uid);
			   int num1=userImpl.updateUserMoney(user);
			   if(num1>0){
				   rBoolean=true;
			   }
			   return rBoolean;
          }
            public int selectNumber(int id){
            	int number=0;
            	bookStock.setId(id);
            	number=bookStockImpl.selectBookNumber(bookStock);
            	return number;
            }
          public void  updateNumber(int id,int number){
        	   numbers=selectNumber(id);
        	   removenumber=numbers-number;
        	   bookStock.setBookNumber(removenumber);
        	   bookStockImpl.updateBookNumber(bookStock);
          }
         public void insertShopping(int uid,String bookName,int bookNumber,double price){
        	  userStock.setUId(uid);
        	  userStock.setBookName(bookName);
        	  userStock.setBuyDate(new Date());
        	  userStock.setBuyNumber(bookNumber);
        	  userStock.setBookPrice(price);
        	  userStockImpl.insertBooks(userStock);
         }
         public void deleteShoppingCart(int scid){
        	 shoppingCart.setScId(scid);
        	 shoppingCartImpl.deleteShoppingCatt(shoppingCart);
         }
          
       public void insertBookCount(int uid,String bookName,int number,double price){
    	    bookCount.setUid(uid);
    	    bookCount.setBookName(bookName);
    	    bookCount.setSellNumber(number);
    	    bookCount.setSellPrice(price);
    	    bookCount.setSellDate(new Date());
    	    bookCountImpl.insertBookCount(bookCount);
       }
          
          
}
