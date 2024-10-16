public class ArithmeticOperator{
	public static void main(String[] args) {
		// 取模的实质 a % b = a - a / b * b => 看前一个的符号 后边当做正数
		System.out.println("10 % 3 = " + (10 % 3));
		System.out.println("10 % -(3) = " + (10 % -3));
		System.out.println("-10 % 3 = " + (-10 % 3));
		System.out.println("-10 % (-3) = " + (-10 % -3));
	}
}