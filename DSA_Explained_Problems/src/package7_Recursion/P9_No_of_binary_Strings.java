package package7_Recursion;

public class P9_No_of_binary_Strings {
	
	/*
	 * Question:-
	 * print all the binary strings with n size
	 * where there should not be any consecutive 0's
	 */
	
	/*
	 * for printing all possible ways :-
	 *
	        // choice 1
			printBinaryStrings(n-1, 0, str+"0");
			// choice 2
			printBinaryStrings(n-1, 1, str+"1");
	 * 
	 */
	
	
	/*
	 * for printing without consective 0's :-
	 * 
	 if(previousPlaceValue == 0) {
			printBinaryStrings(n-1, 1, str+"1");
		}else {
			// choice 1
			printBinaryStrings(n-1, 0, str+"0");
			// choice 2
			printBinaryStrings(n-1, 1, str+"1");
		}
	 */
	
	
	/*
	 * 
	 * for printing without consecutive 1's :-
	  
	  
		if(previousPlaceValue == 1) {
			printBinaryStrings(n-1, 0, str+"0");
		}else {
			// choice 1
			printBinaryStrings(n-1, 0, str+"0");
			// choice 2
			printBinaryStrings(n-1, 1, str+"1");
		}
	  
	 * 
	 */
	
	

	public static void printBinaryStrings(int n, int previousPlaceValue, String str) {
		
		if(n==0) {
			System.out.println(str);
			return;
		}
		
		
		if(previousPlaceValue == 0) {
			printBinaryStrings(n-1, 1, str+"1");
		}else {
			// choice 1
			printBinaryStrings(n-1, 0, str+"0");
			// choice 2
			printBinaryStrings(n-1, 1, str+"1");
		}
		
	}
	
	
	
	public static void main(String[] args) {
		
		printBinaryStrings(3, 0, "");

	}

}
