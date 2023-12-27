package package6_Bit_manipulation;

public class P6_Clear_Last_i_bits {
	
	/*
	 * if 1 is shifted then all the elements to left of 1 and right are 0
	 * now, if there is 111111, and if you leftshit it two times, = 111100
	 * so you need to AND given n with ~0 << i times
	 */
	
	public static void clearLastIBits(int n, int i) {
		System.out.println(n & ((~0)<<i));
	}

	public static void main(String[] args) {
		
		clearLastIBits(15, 2);

	}

}
