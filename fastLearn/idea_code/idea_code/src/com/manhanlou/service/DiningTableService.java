package com.manhanlou.service;

import com.manhanlou.dao.DiningTableDAO;
import com.manhanlou.domain.DiningTable;

import java.util.List;

public class DiningTableService {
    private DiningTableDAO diningTableDAO = new DiningTableDAO();
    //获取所有餐桌的信息
    public List<DiningTable> list(){
        return diningTableDAO.queryMulti("select * from DiningTable", DiningTable.class);
    }
}
