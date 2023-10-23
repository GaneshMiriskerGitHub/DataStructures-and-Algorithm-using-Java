package package1_Pattern;

public class Part_1 {
	
	public static void printLeftTriangle(int n) {
		for(int i=1;i<=n;i++) {
			for(int j=1;j<=i;j++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}
	// 1 2 3 4
	// 4 3 2 1
	// n-i+1 => 4-
	public static void printleftInveted(int n) {
		for(int i=1;i<=n;i++) {
			for(int j=1;j<=n-i+1;j++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}
	
	public static void printLeftTriangleNumber(int n) {
		for(int i=1;i<=n;i++) {
			for(int j=1;j<=i;j++) {
				System.out.print(j+" ");
			}
			System.out.println();
		}
	}
	
	public static void printLeftTriangleAlphabets(int n) {
		char ch = 'A';
		for(int i=0;i<n;i++) {
			for(int j=0;j<=i;j++) {
				System.out.print(ch+" ");
				ch++;
			}
			System.out.println();
		}
	}

	public static void main(String[] args) {
		
		int n = 4;
		printLeftTriangle(n);
		System.out.println("---------------");
		printleftInveted(n);
		System.out.println("---------------");
		printLeftTriangleNumber(n);
		System.out.println("---------------");
		printLeftTriangleAlphabets(n);

	}

}
