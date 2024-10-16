package homework;

public class Homework3 {
    public static void main(String[] args) {
        int fish = 24, peanut = 8, rice = 3;
        double min = ((fish + peanut + rice) * 0.8) > (peanut + rice + 16) ? (peanut + rice + 16) : ((fish + peanut + rice) * 0.8);
        System.out.println(min);
    }
}
