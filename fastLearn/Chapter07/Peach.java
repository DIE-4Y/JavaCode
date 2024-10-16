public class Peach {
	public static void main(String[] args) {
		P p = new P();
		int num = p.f1(9);
		if (num == -1){
			System.out.println("out of range 1-10");
		}else {
			System.out.println(num);
		}
	}
}


class P {
	public int f1 (int day) {
		if (day == 10) {
			return 1;
		}else if (day >= 1 && day <= 9){
			return ((f1((day + 1) )+ 1 ) * 2);
		}else {
			return -1;
		}
	}
}