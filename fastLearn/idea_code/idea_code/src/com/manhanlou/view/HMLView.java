package com.manhanlou.view;

import com.manhanlou.domain.Bill;
import com.manhanlou.domain.DiningTable;
import com.manhanlou.domain.Employee;
import com.manhanlou.domain.Menu;
import com.manhanlou.service.BillService;
import com.manhanlou.service.DiningTableService;
import com.manhanlou.service.EmployeeService;
import com.manhanlou.service.MenuService;
import com.manhanlou.utils.Util;

import java.util.List;

public class HMLView {

    private boolean loop = true;
    private char key;
    private EmployeeService employeeService = new EmployeeService();
    private DiningTableService dts = new DiningTableService();
    private MenuService menuService = new MenuService();
    private BillService billService = new BillService();

    public static void main(String[] args) {
        new HMLView().mainMenu();
    }

    public void mainMenu() {
        while (loop) {
            System.out.println("\n============欢迎登入满汉楼============");
            System.out.println("\t\t 1 用户登录");
            System.out.println("\t\t 2 用户退出");
            System.out.print("请输入你的选择>>:");
            key = Util.getChar();
            switch (key) {
                case '1':
                    System.out.print("请输入用户名:>>");
                    String empId = Util.getString();
                    System.out.print("请输入密码>>:");
                    String password = Util.getString();
                    Employee employee = employeeService.getEmployeeByIdAndPwd(empId, password);
                    if (employee != null) {
                        System.out.println("\n============登录成功(" + employee.getName() + ")============");
                        while (loop) {
                            System.out.println("\n============满汉楼二级菜单============");
                            System.out.println("\t\t1 显示餐桌状态");
                            System.out.println("\t\t2 预定餐桌");
                            System.out.println("\t\t3 显示所有菜品");
                            System.out.println("\t\t4 点餐服务");
                            System.out.println("\t\t5 查看账单");
                            System.out.println("\t\t6 结账");
                            System.out.println("\t\t9 退出系统");
                            System.out.print("请输入你的选择>>:");
                            key = Util.getChar();
                            switch (key) {
                                case '1':
                                    listDiningTable();
                                    break;
                                case '2':
                                    orderTable();
                                    break;
                                case '3':
                                    listMenu();
                                    break;
                                case '4':
                                    orderMenu();
                                    break;
                                case '5':
                                    listBill();
                                    break;
                                case '6':
                                    checkout();
                                    break;
                                case '9':
                                    System.out.println("正在退出~~");
                                    loop = false;
                                    break;
                                default:
                                    System.out.println("输入错误 请重新输入");
                                    break;
                            }
                        }
                    } else {
                        System.out.println("登录失败~~");
                    }
                    break;
                case '9':
                    System.out.println("正在退出~~");
                    loop = false;
                    break;
                default:
                    System.out.println("输入错误 请重新输入");
                    break;
            }
        }
    }

    //显示餐桌信息
    public void listDiningTable() {
        System.out.println("\n============显示餐桌状态============");
        List<DiningTable> list = dts.list();
        System.out.println("\n餐桌编号\t\t餐桌状态");
        for (DiningTable diningTable : list) {
            System.out.println(diningTable);
        }
        System.out.println("\n============餐桌状态显示完毕============");
    }

    //预定餐桌
    public void orderTable() {
        System.out.println("\n============预定餐桌============");
        System.out.print("请输入你想预定的餐桌编号（-1退出）>>:");
        int num = Util.getNum();
        if (num == -1) {
            return;
        }
        //二次确认是否预定餐桌
        System.out.println("请确认是否要预定(" + num + ")号餐桌");
        char c = Util.readConfirm();
        if (c == 'N') {
            return;
        }
        //查看餐桌是否存在且是否为空
        DiningTable table = dts.getTableById(num);
        if (table == null) {
            System.out.println("该餐桌不存在");
            return;
        }
        if (!"空".equals(table.getState())) {
            System.out.println("该餐桌已被预订");
            return;
        }
        //成功预定餐桌
        System.out.println("\n============正在预定============");
        System.out.print("请输入预定人姓名>>:");
        String orderName = Util.getString();
        System.out.print("请输入预定人电话>>:");
        String orderTel = Util.getString();
        if (dts.bookTable(num, orderName, orderTel)) {
            System.out.println("\n============预定成功============");
        } else {
            System.out.println("\n============预定失败============");
        }
    }

    //显示菜品信息
    public void listMenu() {
        System.out.println("\n============显示菜品信息============");
        List<Menu> list = menuService.list();
        System.out.println("id\t\t菜品名\t\t类别\t\t价格");
        for (Menu menu : list) {
            System.out.println(menu);
        }
        System.out.println("\n============菜品信息显示完毕============");
    }

    //点餐
    public void orderMenu() {
        System.out.println("\n============正在点餐============");
        System.out.print("请输入餐桌号（-1退出）>>:");
        int diningTableId = Util.getNum();
        if (diningTableId == -1) {
            System.out.println("正在退出~~");
            return;
        }
        DiningTable table = dts.getTableById(diningTableId);
        if (table == null) {
            System.out.println(diningTableId + "号餐桌不存在~~");
            return;
        }
        System.out.print("请输入菜品>>:");
        int menuId = -1;
        while (true) {
            menuId = Util.getNum();
            Menu menu = menuService.getMenuById(menuId);
            if (menu == null) {
                System.out.println(menuId + "号菜品不存在，请重新输入~~");
            } else {
                break;
            }
        }

        System.out.print("请输入菜品数量>>:");
        int num = 0;
        while (true) {
            num = Util.getNum();
            if (num > 0) {
                break;
            } else {
                System.out.println("数量需要大于0，请重新输入~~");
            }
        }
        System.out.println("确定要点" + num + "份 " + menuService.getMenuById(menuId).getName() + "吗？");
        char c = Util.readConfirm();
        if (c == 'N') {
            return;
        } else {
            System.out.println("正在退出~~");
        }
        if (billService.orderMenu(menuId, num, diningTableId)) {
            System.out.println("\n============点餐成功============");
        } else {
            System.out.println("\n============点餐失败============");
        }
    }

    //查看所有账单
    public void listBill() {
        System.out.println("\n============查看账单============");
        List<Bill> bills = billService.list();
        System.out.println("编号\t菜品号\t菜品量\t金额\t\t桌号\t日期\t\t\t\t\t状态");
        for (Bill bill : bills) {
            System.out.println(bill);
        }
        System.out.println("\n============显示完毕============");
    }

    //结账
    public void checkout() {
        System.out.println("\n============结账============");
        System.out.print("请输入结账餐桌号（-1退出）>>:");
        int diningTableId = Util.getNum();
        if (diningTableId == -1) {
            System.out.println("正在退出~~");
            return;
        }
        DiningTable table = dts.getTableById(diningTableId);
        //该餐桌是否存在
        if (table == null) {
            System.out.println("没有该餐桌~~");
            return;
        }
        //查看是否能结账
        Bill bill = billService.getByTableId(diningTableId);
        if (bill == null || !("未结账".equals(bill.getState()))) {
            System.out.println("该餐桌没有需要支付的订单");
            return;
        }
        //开始结账
        System.out.print("请输入支付方式(现金/微信/支付宝)>>:");
        String payType = Util.getString();
        System.out.print("确定是否要结账（Y/N）>>:");
        char c = Util.readConfirm();
        if (c == 'N') {
            System.out.println("取消结账正在退出~~");
            return;
        }
        if (billService.updateBillState(diningTableId, payType)) {
            //结账成功修改餐桌信息
            if (dts.updateTableNull(diningTableId)) {
                System.out.println("============结账成功============");
            }
        } else {
            System.out.println("支付失败，请稍后再试~~");
        }

    }
}
