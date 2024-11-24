package com.nenu.enum_;


/*
    内部类
 */
public class Homework07 {
    public static void main(String[] args) {
        Car car1 = new Car(30.2);
        car1.getAir().monitor();
        Car car2 = new Car(42.8);
        car2.getAir().monitor();
        Car car3 = new Car(-5.3);
        car3.getAir().monitor();
    }
}

class Car {
    private double temperature;

    public class Air {
        public void monitor(){
            if (temperature > 40){
                flow("冷风");
            }else if(temperature > 0){
                flow("暖风");
            }else {
                System.out.println("空调关闭");
            }
        }
    }
    
    public Air getAir(){
        return new Air();
    }

    public void flow(String wind) {
        System.out.println("空调吹"+ wind);
    }

    public Car() {
    }

    public Car(double temperature) {
        this.temperature = temperature;
    }

    public double getTemperature() {
        return temperature;
    }

    public void setTemperature(double temperature) {
        this.temperature = temperature;
    }

}
