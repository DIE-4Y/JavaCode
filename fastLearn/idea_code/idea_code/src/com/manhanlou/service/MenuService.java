package com.manhanlou.service;

import com.manhanlou.dao.MenuDAO;
import com.manhanlou.domain.Menu;

import java.util.List;

public class MenuService {
    private MenuDAO menuDAO = new MenuDAO();
    //返回所有菜品
    public List<Menu> list(){
        return menuDAO.queryMulti("select * from menu", Menu.class);
    }
    //返回单个菜品信息
    public Menu getMenuById(int id){
        return menuDAO.querySingle("select * from menu where id=?",Menu.class,id);
    }
}
