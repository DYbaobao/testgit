package cn.it.ssm.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;










import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import cn.it.ssm.mapper.UserMapper;
import cn.it.ssm.model.Page;
import cn.it.ssm.model.User;
import cn.it.ssm.service.UserService;
import cn.it.ssm.serviceimpl.UserServiceImpl;

@Controller
@RequestMapping("UserController")
public class UserController {  
   // ApplicationContext context=new ClassPathXmlApplicationContext("classpath:spring/applicationContext.xml");
	@Autowired
	private UserServiceImpl userServiceImpl;
	@Autowired
	private UserMapper userMapper;
	
	@RequestMapping("login")
      public String login(User user){
    	  //HttpSession session =request.getSession();
    	   user= userServiceImpl.findUser(user);
    	  if(user==null){
    		   //session.setAttribute("user", user);
    		   return "login";
    	  }
    	  if(user.getUserName()==null){
    		  return "login";
    	  }
    	  
		return "redirect:doPage"; 
      }
      @RequestMapping("doPage")
      public String doPage(Map<String, Object> map,Integer currPageNo){
  		if(currPageNo==null){
    		currPageNo=1;
    	}
      Page pages=new Page();
    
    	pages.setCurrPageNo(currPageNo);
    	pages.setPageSize(3);
    	int totalCount=userMapper.selectPageCountAll();
    	pages.setTotalCount(totalCount);
    	int totalPageCount=pages.getTotalPageCount();
    	pages.setTotalCount(totalCount);
      
    
	     List<User> list= userMapper.selectPageAll((currPageNo-1)*pages.getPageSize(), pages.getPageSize());
	      
	     pages.setList(list);
	      
          map.put("pages",pages);
		return "userList"; 
      }
      
      
      @RequestMapping("update")
	  public ModelAndView update(int id){
    	  ModelAndView mv=new ModelAndView();
    	  User user=new User();
 	      user=userServiceImpl.selectUserById(id);
	    	   mv.addObject("user", user);
	    	   mv.setViewName("updateUser");
		    return mv;
	  }
   

      @RequestMapping("updateSubmit")
      public String updateSubmit(@RequestParam Map<String,Object> map,
    		  @RequestParam("pic")MultipartFile path,HttpServletRequest request,
			  @RequestParam("imurl")String imurl
    		  )throws Exception {

               User user =new User() ;
		  	  for (Map.Entry<String, Object> entry : map.entrySet()) {
		  		String imgname=path.getOriginalFilename();
				String imgurl=request.getSession().getServletContext().getRealPath("/upload");
				
				if(path!=null&&imgname!=null&&imgname.length()>0){
					//��ͼƬ
					String newimgname=UUID.randomUUID()+imgname.substring(imgname.lastIndexOf("."));
					File file=new File(imgurl+"/"+newimgname);
					//���ڴ��е�ͼƬд�������
					path.transferTo(file);
					//System.out.println(newimgname);
					user.setPath(newimgname);
					
				}else{
					
					user.setPath(imurl);
				}        
		  	
		    
                 user.setId(Integer.parseInt((String) map.get("id")));
		  		                  user.setUserName(((String)map.get("userName")));
		  		                  user.setPassword((String)map.get("password"));
		  		                  
		  		                  user.setBirthday( map.get("birthday"));
		  		                 userServiceImpl.updateUser(user);
		        }
    	  return "redirect:doPage"; 
      }
      @RequestMapping("delete/{id}")
	  public String delete(@PathVariable("id")Integer id){
		     userServiceImpl.deleteUser(id);
		  return "redirect:/UserController/doPage";
	  }	
     
      @RequestMapping("/download")
		public String download(String fileName, HttpServletRequest request,
				HttpServletResponse response) {
			response.setCharacterEncoding("utf-8");
			response.setContentType("multipart/form-data");
			//���������÷���ҳ���ͷ me
			
			//ta ��Ϣ, ��������������ص���ʽ
			response.setHeader("Content-Disposition", "attachment;fileName="
					+ fileName);
			try {
				String path = 
						request.getSession().getServletContext().getRealPath("/upload")+"/"+fileName;
				InputStream is = new FileInputStream(new File(path));

				OutputStream os = response.getOutputStream();
				byte[] bytes = new byte[is.available()];
				is.read(bytes);
				os.write(bytes);
				os.close();
				is.close();
			} catch (Exception e) {
				e.printStackTrace();
			} 
	            //  ����ֵҪע�⣬Ҫ��Ȼ�ͳ�������������
	            //java+getOutputStream() has already been called for this response
			return null;
		}
}
