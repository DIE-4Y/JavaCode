public class VarParameterExercise {
	public static void main (String[] args) {
		String name = "����";
		double[] score = {93.1, 90.2, 23.0, 22};
		T t = new T();
		System.out.println(t.getSum(name, score));
	}
}

class T {
	public String getSum(String name,double... scores) {
		double sum = 0.0;
		for (int i = 0; i < scores.length; i++){
			sum += scores[i];
		}
		return (name + "���ܳɼ�Ϊ��" + sum);
	}
}