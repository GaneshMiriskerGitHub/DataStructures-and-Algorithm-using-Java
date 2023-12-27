package package6_Bit_manipulation;

public class P7_Clear_Bits_in_Range {
	
	/*
	 *   you need to have a = (~0) << i   example:- 11111100000
	 *   and 
	 *   you need to have b = (1<<b) - 1  example:- 00000000011
	 *   (Note: 2^b = 1<<b)
	 *   finally our bitMask = a | b      example:- 11111100011
	 *   now ans = n & bitMask
	 */

	public static void clearRangeOfBits(int n, int i, int j) {
		int a = (~0) << (j+1);
		int b = (1<<i)-1;
		
		System.out.println(n & (a|b));
	}
	
	public static void main(String[] args) {
		
		clearRangeOfBits(10, 2, 4);

	}

}
