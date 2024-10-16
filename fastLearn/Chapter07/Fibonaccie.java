public class Fibonaccie {
	public static void main(String[] args) {
		int n = 10;
		T t = new T();
		int res = t.f1(n);
		System.out.println("num " + n + "'s reslut = " + res);
	}
}

class T {
	public int f1 (int n) {
		if (n == 1 || n == 2) {
			return 1;
		}else {
			return f1(n-1) + f1(n-2);
		}
	}
}