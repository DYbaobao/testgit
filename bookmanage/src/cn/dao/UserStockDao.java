package cn.dao;

import java.util.List;

import cn.model.UserStock;

public interface UserStockDao {
     int insertBooks(UserStock userStock);
     List<UserStock> selectUserStock(UserStock userStock);
}
