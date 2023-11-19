package package5_Bit_manipulation;

public class P1_check_even_or_odd {
	
	/*
	 * all the even numbers have last number 0
	 * all the odd  numbers have last number 1
	 * 
	 * ans:-  AND operator
	 */

	public static void findEvenOdd(int n) {
		if((n & 1) == 0) {
			System.out.println("even");
		}else {
			System.out.println("odd");
		}
	}
	
	public static void main(String[] args) {
		
		findEvenOdd(5);

	}

}
