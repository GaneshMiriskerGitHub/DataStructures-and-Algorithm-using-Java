package package6_Bit_manipulation;

public class P2_Get_ith_Bit {
	
	/*
	 * if AND with 1 at ith position,
	 * you can find what number is present 
	 * 
	 * to AND 1 at ith position shift the 1 i'times
	 * 
	 * so, AND with 1<<i
	 */

	public static void getIthBit(int n, int i) {
		System.out.println(n & (1<<i));
	}
	
	public static void main(String[] args) {
		
		int i = 1;
		int n = 5;
		getIthBit(n, 0);

	}

}
