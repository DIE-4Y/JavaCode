public class HomeWork09 {
	public static void main (String[] args) {
		Music m1 = new Music();
		m1.name = "new Boy";
		m1.times = 180;
		m1.play();
		String infor = m1.getInfo();
		System.out.println(infor);
	}
}

class Music {
	String name;
	int times;
	public void play () {
		System.out.println(name);
	}
	public String getInfo() {
		String infor = "name:";
		infor += this.name;
		infor += ",times:";
		infor += this.times;
		return infor;
	}
}