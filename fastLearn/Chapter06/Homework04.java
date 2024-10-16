public class Homework04 {
	public static void main(String[] args) {
		int [] array = {10, 12, 22, 45, 90};
		int insertNum = 100, index = array.length;
		for (int i = 0 ; i < array.length; i++){
			if(array[i] > insertNum) {
				index = i;
				break;
			}
		}

		// System.out.println(index);

		int[] newArray = new int [array.length + 1];
		for (int i = 0, j = 0; i < newArray.length; i++) {
			if (i == index) {
				newArray[i] = insertNum;
				i++;
			}else { //this else is vital !! uless it will out of range
				newArray[i] = array[j];
				j++;
			}
		}
		array = newArray;
		for (int i = 0; i < array.length; i++) {
			System.out.print(array[i] + "\t");
		}
	}
}