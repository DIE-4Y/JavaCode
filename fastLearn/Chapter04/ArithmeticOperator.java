public class ArithmeticOperator{
	public static void main(String[] args) {
		// ȡģ��ʵ�� a % b = a - a / b * b => ��ǰһ���ķ��� ��ߵ�������
		System.out.println("10 % 3 = " + (10 % 3));
		System.out.println("10 % -(3) = " + (10 % -3));
		System.out.println("-10 % 3 = " + (-10 % 3));
		System.out.println("-10 % (-3) = " + (-10 % -3));
	}
}