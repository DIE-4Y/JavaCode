public class VarParameter {
	public static void main (String[] args) {
		T t = new T();
		int[] array = {2, 3, 7, 9, 10};
		int res1 = t.getSum(array);
		System.out.println("res1�Ľ����"+res1);
		double res2 = t.getSum2(2, 9.0, 8, 90, 9.2);
		System.out.println("res2�Ľ����"+res2);
	}
}

//����Ŀɱ����������0�� Ҳ�����Ƕ��
//�ɱ������ʵ�ο�Ϊ���� ʵ�ʿɱ������������
//�ɱ�������Ժ������βη���һ�� �����������
//һ���β��б��� ���ֻ����һ���ɱ����

class T{
	public int getSum(int... nums) {
		int sum = 0;
		System.out.println("һ����" + nums.length + "������");
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