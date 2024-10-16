public class HomeWork04 {
	public static void main (String[] args) {
		A03 a3 = new A03();
		double[] oldArr = {39.3, 31.8, 395.3, 95.3, 2.89, 0.43};
		double[] newArr = a3.copyArr(oldArr);
		for (int i = 0; i < newArr.length; i++) {
			System.out.print(newArr[i] + " ");
		}
	}
}


class A03 {
	public double[] copyArr(double[] oldArr) {
		double[] newArr = new double[oldArr.length];
		for (int i = 0; i < oldArr.length; i++) {
			newArr[i] = oldArr[i];
		}
		return newArr;
	}
}