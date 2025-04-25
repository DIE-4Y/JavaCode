package com.manhanlou.service;

import com.manhanlou.dao.DiningTableDAO;
import com.manhanlou.domain.DiningTable;

import java.util.List;

public class DiningTableService {
    private DiningTableDAO diningTableDAO = new DiningTableDAO();

    //获取所有餐桌的信息
    public List<DiningTable> list() {
        return diningTableDAO.queryMulti("select * from DiningTable", DiningTable.class);
    }

    //获取餐桌
    public DiningTable getTable() {
        return diningTableDAO.querySingle("select * from DiningTable where id = ?", DiningTable.class, 1);
    }

    //预定餐桌填写信息
    public boolean bookTable(int id, String orderName, String orderTel) {
        int update = diningTableDAO.update("update diningTable set state = '已预订' , orderName = ? , orderTel = ? where id = ?", orderName, orderTel, id);
        return update > 0;
    }
}
