package package4_Bit_manipulation;

public class A2_swap_two_numbers {

	public static void main(String[] args) {
		
		int a = 1;
		int b = 2;
		
		System.out.println("before code = "+ " a is : "+a+" b is : "+b);
		a = a^b;
		b = a^b;
		a = a^b;
		System.out.println("after code = "+ " a is : "+a+" b is : "+b);

	}

}
