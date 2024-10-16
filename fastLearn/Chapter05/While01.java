public class While01 {
	public static void main(String[] args) {
		double cache = 100000.0;
		int count = 0;
		while(cache > 0) {
			if(cache > 50000) {
				cache *= 0.95;
			}else {
				cache -= 1000;
			}
			count ++;
		}
		System.out.println(count);
	}
}