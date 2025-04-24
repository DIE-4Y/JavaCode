package com.manhanlou.view;

import com.manhanlou.domain.DiningTable;
import com.manhanlou.domain.Employee;
import com.manhanlou.service.DiningTableService;
import com.manhanlou.service.EmployeeService;
import com.manhanlou.utils.Util;

import java.util.List;

public class HMLView {

    private boolean loop = true;
    private char key;
    private EmployeeService employeeService = new EmployeeService();
    private DiningTableService dts = new DiningTableService();

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
                                    System.out.println("\n============预定餐桌============");

                                    break;
                                case '3':
                                    System.out.println("\n============显示所有菜品============");

                                    break;
                                case '4':
                                    System.out.println("\n============点餐服务============");
                                    break;
                                case '5':
                                    System.out.println("\n============查看账单============");
                                    break;
                                case '6':
                                    System.out.println("\n============结账============");
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

    public void listDiningTable() {
        System.out.println("\n============显示餐桌状态============");
        List<DiningTable> list = dts.list();
        System.out.println("\n餐桌编号\t\t餐桌状态");
        for (DiningTable diningTable : list) {
            System.out.println(diningTable);
        }
        System.out.println("\n============餐桌状态显示完毕============");
    }
}
