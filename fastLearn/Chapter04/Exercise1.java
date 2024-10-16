public class Exercise1{
	public static void main(String[] args){
		//(1)temp = 1; (2) i = i + 1; (3) i = temp
		int i = 1;
		i = i++;
		System.out.println(i);
		//(1)i = i + 1; (2)temp = i; (3) i = temp
		int x = 1;
		x = ++x;
		System.out.println(x);
	}
}