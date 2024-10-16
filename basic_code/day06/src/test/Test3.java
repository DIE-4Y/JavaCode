package test;

public class Test3 {
    public static void main(String[] args) {
        int area1 = getArea(35, 90);
        int area2 = getArea(46, 56);
        if(area1 > area2){
            System.out.println("the first is bigger");
        }
        else{
            System.out.println("the second is bigger");
        }
    }

    public static int getArea(int len, int width){
        int area = len * width;
        return area;
    }

}
