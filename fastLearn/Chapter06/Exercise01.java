public class Exercise01 {
	public static void main (String[] args) {
		AA a1 = new AA();
		int num = 10;
		boolean flag = a1.judgeNum(num);
		System.out.println("it's oushu is "+ flag);
		a1.printArr(4,4,4);
	}


}

class AA {	

	public boolean judgeNum(int num) {
		if (num  % 2 == 0) {
			return true;
		}else {
			return false;
		}
	}

	public void printArr(int a, int b, int key) {
		for(int i = 1; i <= a; i++) {
			for (int j = 1; j <= b; j++) {
				System.out.print(key + " ");
			}
			System.out.println();
		}
	}
}
