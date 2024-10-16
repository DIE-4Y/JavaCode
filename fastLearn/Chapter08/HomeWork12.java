public class HomeWork12 {
	public static void main (String[] args) {
		Employee e1 = new Employee("zhangsan", "female", 20);
		Employee e2 = new Employee("engieer", 23535.2);
		Employee e3 = new Employee("zhangsan", "female", 20, "engieer", 20000.4);

	}
}


class Employee {
	String name;
	String gender;
	int age;
	String job;
	double salary;

	public Employee (String name, String gender, int age, String job, double salary) {
		this.name = name;
		this.gender = gender;
		this.age = age;
		this.job = job;
		this.salary = salary;
	}

	public Employee (String name, String gender, int age) {
		this.name = name;
		this.gender = gender;
		this.age = age;
	}

	public Employee (String job, double salary) {
		this.job = job;
		this.salary = salary;
	}
}