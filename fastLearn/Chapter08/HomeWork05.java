public class HomeWork05 {
	public static void main(String[] args) {
		Circle c1 = new Circle();
		c1.redium = 3;
		c1.showChang();
		c1.showSqare();
	}
}


class Circle {
	double redium;
	double chang;
	double sqare;
	public void showChang () {
		System.out.println(redium*3.14*2);
	}

	public void showSqare () {
		System.out.println(redium*redium*3.14);
	}
}