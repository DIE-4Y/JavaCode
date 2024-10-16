public class HomeWork02 {
	public static void main (String[] args) {
		char[] ch = {'a', 'b' , 'c', 'd', 'e', 'f'};
		A02 a2 = new A02();
		int flag = a2.find('z', ch);
		if (flag == -1) {
			System.out.println("can't find it");
		}else {
			System.out.println("it's index is " + flag);
		}
	}
}


class A02 {
	public int find(char target,char... ch) {
		int index = -1;
		for (int i = 0; i < ch.length; i++) {
			if (ch[i] == target){
				return i;
			}
		}
		return index;
	}
}