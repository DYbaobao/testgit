package cn.ser;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.impl.BookStockImpl;
import cn.model.BookStock;
import cn.model.Page;

public class PageSer extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public PageSer() {
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
	  	String pageIndex=request.getParameter("pageIndex");
    	if(pageIndex==null){
    		pageIndex="1";
    	}
    	int currPageNo=Integer.parseInt(pageIndex);
    	Page pages=new Page();
    	BookStock bookStock =new BookStock();
    	BookStockImpl bookStockImpl = new BookStockImpl();
    	pages.setCurrPageNo(currPageNo);
    	pages.setPageSize(2);
    	int totalCount=bookStockImpl.selectBookStock();
    	pages.setTotalCount(totalCount);
    	int totalPageCount=pages.getTotalPageCount();
    	 List<BookStock> bookStocks=bookStockImpl.selectPageAll(currPageNo,pages.getPageSize());
    	pages.setList(bookStocks);
    	
    	request.setAttribute("pages", pages);
    	request.getRequestDispatcher("/booklist.jsp").forward(request, response);
    	
		
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
