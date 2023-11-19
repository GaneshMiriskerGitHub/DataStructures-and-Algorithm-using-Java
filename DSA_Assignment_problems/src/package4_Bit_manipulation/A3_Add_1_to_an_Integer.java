package package4_Bit_manipulation;

public class A3_Add_1_to_an_Integer {
	
	/*
	 * to convert a integer into negative using bit manipulation
	 * 1. convert all it bits to oppsoite (~)
	 * 2. add 1 to it
	 */

	public static void main(String[] args) {
		
		int a = 1;
		System.out.println("before ~ :"+a);
		a = ~a + 1;
		System.out.println("after ~ :"+a);

	}

}
