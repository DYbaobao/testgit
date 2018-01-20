package cn.dao;

import cn.model.User;

public interface UserDao {
       User  selectOne(User user);
       double  selectMoney(User user);
       int   insertUser(User user);
       int   updateUser(User user);
       int   deleteUser(User user);
       int updateMoney(User user);
}
