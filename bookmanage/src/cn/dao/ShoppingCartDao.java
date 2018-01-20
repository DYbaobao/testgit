package cn.dao;

import java.util.List;

import cn.model.ShoppingCart;

public interface ShoppingCartDao {
     List<ShoppingCart> selectShoppingCart(ShoppingCart shoppingCart);
     int insertShoppingCart(ShoppingCart shoppingCart);
     int deleteShoppingCatt(ShoppingCart shoppingCart);
     double selectShoppingCartPrice(ShoppingCart shoppingCart);
     int selectShoppingCartNumber(ShoppingCart shoppingCart);
     int updateShoppingCartNumber(ShoppingCart shoppingCart);
     
}
