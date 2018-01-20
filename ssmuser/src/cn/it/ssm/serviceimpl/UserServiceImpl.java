package cn.it.ssm.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;





import cn.it.ssm.mapper.UserMapper;
import cn.it.ssm.model.Page;
import cn.it.ssm.model.User;
import cn.it.ssm.service.UserService;


public class UserServiceImpl implements UserService {
   
	@Autowired
	private UserMapper userMapper;
	
	@Override
	public Integer selectPageCountAll() {
	
		return userMapper.selectPageCountAll();
	}

	@Override
	public List<User> selectPageAll(Integer currPageNo) {
		
          return null;
	}

	@Override
	public User findUser(User user) {
		
		return userMapper.findUser(user);
	}

	@Override
	public int updateUser(User user) {
		
		return userMapper.updateUser(user);
	}

	@Override
	public User selectUserById(int id) {
		// TODO Auto-generated method stub
		return userMapper.selectUserById(id);
	}

	@Override
	public int deleteUser(int id) {
		// TODO Auto-generated method stub
		return userMapper.deleteUser(id);
	}
     
}
