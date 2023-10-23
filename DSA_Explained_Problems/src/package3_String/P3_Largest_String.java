package package3_String;

public class P3_Largest_String {
	
	public static void printLargestString(String[] fruits) {
		
		String largestStr = fruits[0];
		for(int i=0;i<fruits.length;i++) {
			if(largestStr.compareToIgnoreCase(fruits[i]) < 0) {
				largestStr = fruits[i];
			}
		}
		
		System.out.println(largestStr);
		
	}

	public static void main(String[] args) {

		String[] fruits = {"apple", "mango", "banana"};
		
		//  logic for printing lexographically largest string: alphabetical order lo largest
		printLargestString(fruits);

	}

}
