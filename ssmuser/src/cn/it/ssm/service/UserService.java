package cn.it.ssm.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.it.ssm.model.User;

public interface UserService {
	    public User findUser(User user);
	    public Integer selectPageCountAll();
	    public List<User> selectPageAll(Integer currPageNo);
	    public int  updateUser(User user);
	    public User selectUserById(int id);
	    public  int deleteUser(int id);
	    
}
