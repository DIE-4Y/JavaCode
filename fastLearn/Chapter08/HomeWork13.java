public class HomeWork13 {
	public static void main (String[] args) {
		Circle c1 = new Circle();
		PassObject p1 = new PassObject();
		p1.printAreas(c1, 5);
	}
}


class Circle {
	double radius;
	public double findArea() {
		return (this.radius * this.radius * 3.14);
	}
}

class PassObject {
	public void printAreas(Circle c, int times){
		System.out.println("Radius\tArea");
		for (int i = 1; i <= times; i++) {
			c.radius = i;
			System.out.println(i + "\t" + c.findArea());
		}
	}
}