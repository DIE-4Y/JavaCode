public class VarParameter {
	public static void main (String[] args) {
		T t = new T();
		int[] array = {2, 3, 7, 9, 10};
		int res1 = t.getSum(array);
		System.out.println("res1的结果是"+res1);
		double res2 = t.getSum2(2, 9.0, 8, 90, 9.2);
		System.out.println("res2的结果是"+res2);
	}
}

//传入的可变参数可以是0个 也可以是多个
//可变参数的实参可为数组 实际可变参数就是数组
//可变参数可以和其他形参放在一起 但必须在最后
//一个形参列表中 最多只能有一个可变参数

class T{
	public int getSum(int... nums) {
		int sum = 0;
		System.out.println("一共有" + nums.length + "个参数");
		for (int i = 0; i < nums.length; i++) {
			sum += nums[i];
		}
		return sum;
	}
	public double getSum2(int n1, double... nums) {
		double sum = n1;
		for (int i = 0 ; i < nums.length; i++) {
			sum += nums[i];
		}
		return sum;
	}
}