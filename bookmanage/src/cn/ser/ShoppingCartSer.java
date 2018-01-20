package cn.ser;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.impl.BookStockImpl;
import cn.impl.ShoppingCartImpl;
import cn.manager.PayMoneyManager;
import cn.model.BookStock;
import cn.model.ShoppingCart;

public class ShoppingCartSer extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public ShoppingCartSer() {
		super();
	}

	/**
	 * Destruction of the servlet. <br>
	 */
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

	/**
	 * The doGet method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		this.doPost(request, response);
	}

	/**
	 * The doPost method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to post.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
               request.setCharacterEncoding("UTF-8");
               ShoppingCart shoppingCart = new ShoppingCart();
               ShoppingCartImpl shoppingCartImpl = new ShoppingCartImpl();
               BookStockImpl bookStockImpl= new BookStockImpl();
               PayMoneyManager payMoneyManager= new PayMoneyManager();
               
               String statu=request.getParameter("statu");
               if(statu.equals("insertBook")){
            	   String Uids=(String)request.getParameter("Uid");
            	     int Uid=Integer.parseInt(Uids);
            	     String prices=(String)request.getParameter("bookPrice");
            	     double price=Double.parseDouble(prices);
            	     String numbers=(String)request.getParameter("bookNumber");
            	     int number=Integer.parseInt(numbers);
            	     String bookName=(String)request.getParameter("bookName");
            	     String publisher=(String)request.getParameter("publisher");
            	     Object publishingDate=request.getParameter("publishingDate");
            	     
            	     
            	     shoppingCart.setUId(Uid);
            	     
            	     shoppingCart.setPrice(price);
            	     shoppingCart.setNumber(number);
            	     shoppingCart.setBookName(bookName);
            	     shoppingCart.setAddDate(new Date());
            	     shoppingCart.setPublisher(publisher);
            	     shoppingCart.setPublishingDate(publishingDate);
            	     double sumMoney=price*number;
            	     shoppingCart.setSumMoney(sumMoney);
            	     int num=shoppingCartImpl.insertShoppingCart(shoppingCart);
            	     if(num>0){
            	    	 String ids=(String)request.getParameter("id");
            	    	 int id=Integer.parseInt(ids);
            	    	 payMoneyManager.updateNumber(id, number);
            	    	 ArrayList<BookStock> bookStocks=(ArrayList<BookStock>) bookStockImpl.selectBookStockAll();
                     	 request.setAttribute("bookStocks", bookStocks);
                         request.setAttribute("buy", "加入购物车成功");
            	    	 request.getRequestDispatcher("/usermanager.jsp").forward(request, response);
            	    }
               }else if(statu.equals("selectShoppingAll")){
            	   String Uids=(String)request.getParameter("Uid");
          	        int Uid=Integer.parseInt(Uids);
          	        shoppingCart.setUId(Uid);
          	       ArrayList<ShoppingCart> shoppingCarts=(ArrayList<ShoppingCart>) shoppingCartImpl.selectShoppingCart(shoppingCart);
          	       request.setAttribute("shoppingCarts", shoppingCarts);
          	       request.getRequestDispatcher("/usermanager.jsp").forward(request, response);
               }else if(statu.equals("pay")){
            	   String scids=(String)request.getParameter("scid");
         	        int scId=Integer.parseInt(scids);
         	       String Uids=(String)request.getParameter("uid");
         	        int Uid=Integer.parseInt(Uids);
         	         String bookName=(String)request.getParameter("bookName");
         	        String numbers=(String)request.getParameter("bookNumber");
           	        int number=Integer.parseInt(numbers);
           	      String prices=(String)request.getParameter("bookPrice");
        	      double price=Double.parseDouble(prices);
         	       payMoneyManager.insertShopping(Uid, bookName, number,price);
         	       payMoneyManager.deleteShoppingCart(scId);
         	       String sumPrices=(String)request.getParameter("sumMoney");
         	       double sumPrice=Double.parseDouble(sumPrices);
         	       payMoneyManager.insertBookCount(Uid, bookName, number, sumPrice);
         	        Boolean br=  payMoneyManager.payMoney(scId, Uid);
         	         if(br){
         	        	 request.setAttribute("paymoney", "付款成功");
         	        	 request.getRequestDispatcher("/usermanager.jsp").forward(request, response);
         	         }
               }
		
	}

	/**
	 * Initialization of the servlet. <br>
	 *
	 * @throws ServletException if an error occurs
	 */
	public void init() throws ServletException {
		// Put your code here
	}

}
