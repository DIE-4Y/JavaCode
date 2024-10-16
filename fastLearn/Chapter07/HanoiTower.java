public class HanoiTower {
	public static void main (String[] args) {
		Tower t1 = new Tower();
		t1.move(2, 'A', 'B', 'C');
	}
}

class Tower {
	public void move (int n, char a, char b , char c) {
		if (n == 1) {
			System.out.println(a + "->" + c);
		}else {
			move(n-1, a, c, b);
			System.out.println(a + "->" + c);
			move(n-1, b, a, c);
		}
	}
}