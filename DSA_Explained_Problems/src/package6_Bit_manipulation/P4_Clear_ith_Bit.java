package package6_Bit_manipulation;

public class P4_Clear_ith_Bit {

	/*
	 *  if AND with 0 at ith position then 
	 *  bit will set to 0
	 *  so AND with ~(1<<i)
	 *  initially (1<<i) : will shift the 1 at ith position and makes all left and right elements as 0
	 *  but after applying compliment,
	 *  so that ith position will be 0 and remaing digits to left and right becomes 1
	 */
	
	public static void clearIthBit(int n, int i) {
		System.out.println(n & (~(1<<i)));
	}
	
	public static void main(String[] args) {
		
		int i = 0;
		int n = 5;
		clearIthBit(n, i);

	}

}
