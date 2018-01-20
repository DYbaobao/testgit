package cn.ser;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.impl.UserImpl;
import cn.model.User;

public class UserSer extends HttpServlet {

	/**
	 * Constructor of the object.
	 */
	public UserSer() {
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
            User user = new User();
            UserImpl userImpl= new UserImpl();
            HttpSession session =request.getSession();
            String statu=request.getParameter("statu");
            if(statu.equals("login")){
            	    user.setUserName((String)request.getParameter("username"));
            		user.setPassword((String)request.getParameter("password"));
            	//user.setIsLeader(isLeader);
            		user=userImpl.selectOne(user);
            		if(user.getUserName()!=null&user.getPassword()!=null){
            			if(user.getIsLeader()==1){
            				user.setUserName((String)request.getParameter("username"));
            				user=userImpl.selectId(user);
            				session.setAttribute("usermanager", user);
            			  request.getRequestDispatcher("/managerwelcome.jsp").forward(request, response);
            			} else if(user.getIsLeader()==0){
            				user.setUserName((String)request.getParameter("username"));
            				user=userImpl.selectId(user);
            				session.setAttribute("user", user);
            				request.getRequestDispatcher("/welcome.jsp").forward(request, response);
            			}
            		}else{
            			if(user.getIsLeader()==1){
            			  request.getRequestDispatcher("/login.jsp").forward(request, response);
            			}else if(user.getIsLeader()==0){
            				request.getRequestDispatcher("/register.jsp").forward(request, response);
            			}
            		}
            } else if(statu.equals("register")){
            	user.setUserName((String)request.getParameter("username"));
        		user.setPassword((String)request.getParameter("password"));
        		String money_s=request.getParameter("money");
        		double money=Double.parseDouble(money_s);
        		//System.out.println(money);
        		user.setMoney(money);
        		user.setIsLeader(0);
        		//user=userImpl.selectOne(user);
        		/*if(user.getUserName()==null&user.getPassword()==null){*/
        			int num=userImpl.insertUser(user);
            		if(num>0){
            			  request.getRequestDispatcher("/login.jsp").forward(request, response);
            		}else{
            			request.getRequestDispatcher("/register.jsp").forward(request, response);
            		}
        		/*}else {
        			
        			request.getRequestDispatcher("/register.jsp").forward(request, response);
        		}*/
        		
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
