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
import cn.model.BookStock;
import cn.model.Page;

public class BookStockSer extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public BookStockSer() {
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
            Page page = new Page();
            String statu=(String)request.getParameter("statu");
            BookStock bookStock =new BookStock();
             BookStockImpl bookStockImpl = new BookStockImpl();
             
            if(statu.equals("selectBookStock")){
            	String bookName=(String)request.getParameter("bookName");
            	bookStock.setBookName(bookName);
            	ArrayList<BookStock> bookStocks=(ArrayList<BookStock>) bookStockImpl.selectBookStock(bookStock);
            	request.setAttribute("bookStocks", bookStocks);
            	request.getRequestDispatcher("/booklist.jsp").forward(request, response);
            }else if(statu.equals("insertBookStock")){
            	String bookName=(String)request.getParameter("bookName");
            	String bookContent=(String)request.getParameter("bookContent");
            	String publisher=(String)request.getParameter("publisher");
            	Object publishingDate=request.getParameter("publishingDate");
            	String bookPrices=(String)request.getParameter("bookPrice");
            	double bookPrice=Double.parseDouble(bookPrices);
            	String bookNumbers=(String)request.getParameter("bookNumber");
            	int bookNumber=Integer.parseInt(bookNumbers);
            	bookStock.setBookName(bookName);
            	bookStock.setBookContent(bookContent);
            	bookStock.setPublisher(publisher);
            	bookStock.setPublishingDate(publishingDate);
            	bookStock.setAddDate(new Date());
            	bookStock.setBookPrice(bookPrice);
            	bookStock.setBookNumber(bookNumber);
                int num=bookStockImpl.insertBooksStock(bookStock);
                if(num>0){
                	ArrayList<BookStock> bookStocks=(ArrayList<BookStock>) bookStockImpl.selectBookStockAll();
                	request.setAttribute("bookStocks", bookStocks);
                	request.getRequestDispatcher("/booklist.jsp").forward(request, response);
                }else {
                	request.getRequestDispatcher("/insertBookStock.jsp").forward(request, response);
                }
            }else if(statu.equals("delete")){
            	  String ids=(String)request.getParameter("id");
            	  int id=Integer.parseInt(ids);
            	  bookStock.setId(id);
            	 int num= bookStockImpl.deleteBooksStock(bookStock);
            	 if(num>0){
            		 ArrayList<BookStock> bookStocks=(ArrayList<BookStock>) bookStockImpl.selectBookStockAll();
                 	 request.setAttribute("bookStocks", bookStocks);
                 	request.getRequestDispatcher("/booklist.jsp").forward(request, response);
            	 }
            }else if(statu.equals("books")){
            	String bookName=(String)request.getParameter("name");
            	bookStock.setBookName(bookName);
            	ArrayList<BookStock> bStocks=(ArrayList<BookStock>) bookStockImpl.selectBookStock(bookStock);
            	request.setAttribute("bStocks", bStocks);
             	request.getRequestDispatcher("/books.jsp").forward(request, response);
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
