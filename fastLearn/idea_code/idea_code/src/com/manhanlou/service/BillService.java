package com.manhanlou.service;

import com.manhanlou.dao.BillDAO;
import com.manhanlou.domain.Bill;

import java.util.List;
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

    //查看所有账单功能
    public List<Bill> list() {
        return billDAO.queryMulti("select * from bill", Bill.class);
    }

    //获取某个账单
    public Bill getByTableId(int diningTableId) {
        return billDAO.querySingle("select * from bill where diningTable=? and state ='未结账' limit 0, 1", Bill.class, diningTableId);
    }

    //修改账单状态
    public boolean updateBillState(int diningTableId, String state) {
        int update = billDAO.update("update bill set state=? where diningTable=? and state='未结账'", state, diningTableId);
        return update > 0;
    }
}
