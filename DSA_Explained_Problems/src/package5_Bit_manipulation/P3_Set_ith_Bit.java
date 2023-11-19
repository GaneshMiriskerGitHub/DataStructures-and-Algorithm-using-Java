package package5_Bit_manipulation;

public class P3_Set_ith_Bit {
	
	/*
	 * OR 1 with a number gives the same number = 1
	 * so, shift the 1 i'times and OR
	 */

	public static void setIthBit(int n, int i) {
		System.out.println(n | (1<<i));
	}
	
	public static void main(String[] args) {
		
		int i=0;
		int n=5;
		setIthBit(n, i);

	}

}
