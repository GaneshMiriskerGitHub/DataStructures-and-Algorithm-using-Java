package package7_Recursion;

public class P8_Friends_Pairing_Problem { 
	
	/*
	 * resources :- 1st apna college
	 * youtube :- https://www.youtube.com/watch?v=SHDu0Ufjyk8
	 */

 	
	public static int noOfWays(int n) {
		
		if( n == 0 ) return 0;
		if( n == 1 ) return 1;
		if( n == 2 ) return 2;
		
		// no pair
		int w1 = 1*noOfWays(n-1);
		
		// pair
		int w2 = (n-1) * noOfWays(n-2);
		
		int totalWays = w1 + w2;
		
		return totalWays;
	}

	public static void main(String[] args) {
		
		System.out.println(noOfWays(3));

	}

}