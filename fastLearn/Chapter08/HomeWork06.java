public class HomeWork06 {
	public static void main (String[] args) {
		Cale c1 = new Cale();
		c1.n1 = 3.2;
		c1.n2 = 2;
		Cale c2 = new Cale();
		c2.n1 = 9;
		c2.n2 = 0;
		c1.showDiv();
		c2.showDiv();
	}
}


class Cale {
	double n1, n2;
	public void showAdd () {
		System.out.println(n1+n2);
	}
	public void showSub () {
		System.out.println(n1-n2);
	}
	public void showMul () {
		System.out.println(n1*n2);
	}
	public void showDiv () {
		if (n2 - 0 < 0.000000001)  {
			System.out.println("n2 can't be 0");
		}else {
			System.out.println(n1/n2);
		}
	}
}