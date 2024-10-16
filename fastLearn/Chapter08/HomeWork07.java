public class HomeWork07 {
	public static void main (String[] args) {
		Dog d1 = new Dog();
		d1.name = "Sb";
		d1.color = "blue";
		d1.age = 20;
		d1.show();
	}
}

class Dog {
	String name;
	String color;
	int age;
	public void show() {
		System.out.println("Dog's name is " + this.name);
		System.out.println("Dog's color is " + this.color);
		System.out.println("Dog's age is " + this.age);
	}
}