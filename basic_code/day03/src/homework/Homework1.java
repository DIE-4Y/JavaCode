package homework;

public class Homework1 {
    public static void main(String[] args)
    {
        double fatherage = 177.0, motherage = 165.0, sonage, daughterage;
        sonage = (fatherage + motherage) * 1.08 / 2;
        daughterage = (fatherage * 0.95 + motherage) / 2;
        System.out.println("儿子的身高为" + sonage);
        System.out.println("女儿的身高为" + daughterage);
    }
}
