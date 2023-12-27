package package7_Recursion;

public class P3_Fibonacci {
	
	// 0 1 1 2 3 5 8
	
	public static int fibonacci(int n) {
		if(n == 0) return 0;
		if(n == 1 || n == 2) return 1;
		
		return fibonacci(n-1)+fibonacci(n-2);
	}

	public static void main(String[] args) {
		
		int n = 5;
		
		System.out.println(fibonacci(n));

	}

}
