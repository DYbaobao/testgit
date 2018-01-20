package cn.it.ssm.mapper;



import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.it.ssm.model.User;
 
public interface UserMapper {
    public User findUser(User user);
    public Integer selectPageCountAll();
    public List<User> selectPageAll(@Param("currPageNo")Integer currPageNo,@Param("pageSize")Integer pageSize );
    
    public int  updateUser(User user);
    
    public User selectUserById(int id);
    
    public  int deleteUser(int id);
}
