package com.manhanlou.service;

import com.manhanlou.dao.BillDAO;

import java.util.UUID;

public class BillService {
    private BillDAO billDAO = new BillDAO();
    //添加MenuService属性
    private MenuService menuService = new MenuService();
    //添加diningTableService
    private DiningTableService dts = new DiningTableService();

    //点餐
    public boolean orderMenu(int menuId, int nums, int diningTable) {
        //1.生成账单
        String billId = UUID.randomUUID().toString();
        int update = billDAO.update("insert into bill values(null,?,?,?,?,?,now(),'未结账')", billId, menuId, nums, menuService.getMenuById(menuId).getPrice() * nums, diningTable);
        if (update <= 0) {
            return false;
        }
        //2.更新餐桌状态
        return dts.updateState("用餐中", diningTable);
    }
}
