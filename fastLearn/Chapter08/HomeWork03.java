public class HomeWork03 {
	public static void main (String[] args) {
		Book b1 = new Book();
		b1.price = 200;
		b1.updatePrice();
		System.out.println("book's price is " + b1.price);
	}
}


class Book {
	double price;
	public void updatePrice(){
		if (this.price > 150) {
			this.price = 150;
		}else if (this.price > 100) {
			this.price = 100;
		}
	}
}