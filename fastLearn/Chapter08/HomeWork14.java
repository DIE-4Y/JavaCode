import java.util.Scanner;

public class HomeWork14 {
	public static void main(String[] args) {
		Scanner myScanner = new Scanner(System.in);
		Tom t1 = new Tom();
		do{
			System.out.println("input your puch 0-2");
			int puch = myScanner.nextInt();
			if (puch > 2 || puch < 0){
				System.out.println("input out of range 0-2");
				break;
			}
			t1.guess(puch);
			System.out.println("Countinue to play ? y/n");
			char ch = myScanner.next().charAt(0);
			if(ch == 'n') {
				break;
			}
		}while(true);
		
		System.out.println("you wan " + t1.getWin() + " games");
		System.out.println("you Lose " + t1.getLose() + " games");
	}
}

class Tom {
	int win;
	int lose;
	public void guess (int punch){
		int computer =  (int) (Math.random() * 3);
		if (punch - computer == -1 || punch - computer == 2) {
			this.win++;
			System.out.println("You Win!");
		}else if (punch - computer == 1 || punch - computer == -2) {
			this.lose++;
			System.out.println("You Lose!");
		}
	}

	public int getWin(){
		return win;
	}

	public int getLose() {
		return lose;
	}
}