package package7_Recursion;

public class P5_Pow {
	
	public static int pow1(int n, int p) {
		
		if(p == 0) return 1;
		if(p == 1) return n;
		
		return n*pow1(n, p-1);
	}
	
	
	// Optimized
	public static int pow2(int n, int p) {
		
		if(p==0) return 1;
		
		if(p%2 == 0) {
			return pow2(n, p/2) * pow2(n, p/2);
		}
		else{
			return n*pow2(n, p/2) * pow2(n, p/2);
		} 
	}

	public static void main(String[] args) {
		
		System.out.println(pow2(2, 3));

	}

}
