package package7_Recursion;

public class P2_Sum_Of_N_Numbers {
	
	public static int sumOfN(int n) {
		
		if(n == 1) return 1;
		
		return n+sumOfN(n-1);
	}

	public static void main(String[] args) {
		
		int n = 5;
		
		System.out.println(sumOfN(n));

	}

}
