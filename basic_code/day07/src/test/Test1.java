package test;

import java.util.Scanner;

public class Test1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入机票原价");
        int tickt = sc.nextInt();
        System.out.println("请输入月份");
        int month = sc.nextInt();
        System.out.println("请输入当前购买的仓位： 0 -> 头等舱， 1 -> 经济舱");
        int seat = sc.nextInt();
        if(month >= 5 && month <= 10) {
            tickt = getTickt(seat, tickt, 0.9, 0.85);
        }
        else if((month >= 11 && month <= 12) || (month <= 4 && month >= 1)){
            tickt = getTickt(seat, tickt, 0.7, 0.65);
        }
        else{
            System.out.println("月份不合法");
        }
        System.out.println(tickt);
    }

    private static int getTickt(int seat, int tickt, double x, double x1) {
        if (seat == 0) {
            tickt = (int) (tickt * x);
        } else if (seat == 1) {
            tickt = (int) (tickt * x1);
        } else {
            System.out.println("没有这个舱位");
        }
        return tickt;
    }
    
    /*
    public static int ticiktPrice(int tickt, int seat,  double dicount1, double diccount2){
        if(seat == 0){
            tickt = (int)(tickt*dicount1);
            return tickt;
        }
        else if(seat == 1){
            tickt = (int)(tickt*diccount2);
            return tickt;
        }
        else{
            System.out.println("没有这个舱位");
        }
    }
     */

}