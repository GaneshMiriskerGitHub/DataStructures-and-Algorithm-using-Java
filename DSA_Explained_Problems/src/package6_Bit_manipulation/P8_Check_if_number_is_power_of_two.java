package package6_Bit_manipulation;

public class P8_Check_if_number_is_power_of_two {
	
	/*
	 * if a number is power of 2 
	 * then its n&(n-1) == 0
	 */

	public static void check2Power(int n) {
		System.out.println((n&(n-1)) == 0);
	}
	
	public static void main(String[] args) {
		
		check2Power(2);

	}

}
