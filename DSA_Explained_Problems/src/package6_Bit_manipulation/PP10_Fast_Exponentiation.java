package package6_Bit_manipulation;

public class PP10_Fast_Exponentiation {
	
	/*
	 *    a^5  can be a^101
	 *    so each iteration , we must check the last digit in the 101
	 *    and increase the a square times
	 */

	public static void printPow(int n, int p) {
		
		int ans = 1;
		while(p > 0) {
			if((p&1) == 1) {
				ans = ans * n;
			}
			n = n*n;
			p = p>>1;
		}
		
		System.out.println(ans);
	}
	
	public static void main(String[] args) {
		
		printPow(2, 3);

	}

}
