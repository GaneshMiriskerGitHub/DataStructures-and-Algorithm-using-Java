package package1_Pattern;

public class Part_2 {

	// Hollow
	public static void patter1(int n) {
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (i == 0 || j == 0 || i == n - 1 || j == n - 1) {
					System.out.print("*");
				} else {
					System.out.print(" ");
				}
			}
			System.out.println();
		}
	}

	// inverted & Rotated Half pyramid : right half traingle
	public static void pattern2(int n) {
		for (int i = 0; i < n; i++) {
			// spaces
			for (int j = 0; j < n - i; j++) {
				System.out.print(" ");
			}
			// '*'
			for (int j = 0; j < i; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}

	// Reverse left triangle left numbers
	public static void pattern3(int n) {
		for (int i = 0; i < n; i++) {
			for (int j = 1; j <= n - i; j++) {
				System.out.print(j + " ");
			}
			System.out.println();
		}
	}

	// Floyd's triangle pattern
	public static void pattern4(int n) {
		int num = 1;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j <= i; j++) {
				System.out.print(num + " ");
				num++;
			}
			System.out.println();
		}
	}

	// 0-1 triangle
	public static void pattern5(int n) {
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= i; j++) {
				if ((i + j) % 2 == 0) {
					System.out.print("1 ");
				} else {
					System.out.print("0 ");
				}
			}
			System.out.println();
		}
	}

	// butterfly
	public static void pattern6(int n) {
		for (int i = 1; i <= n; i++) {
			// "*"
			for (int j = 1; j <= i; j++) {
				System.out.print("*");
			}
			// " "
			for (int j = 1; j <= (2 * (n - i)); j++) {
				System.out.print(" ");
			}
			// "*"
			for (int j = 1; j <= i; j++) {
				System.out.print("*");
			}
			System.out.println();
		}

		for (int i = n; i >= 0; i--) {
			// "*"
			for (int j = 1; j <= i; j++) {
				System.out.print("*");
			}
			// " "
			for (int j = 1; j <= (2 * (n - i)); j++) {
				System.out.print(" ");
			}
			// "*"
			for (int j = 1; j <= i; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}

	// Rhombus
	public static void pattern7(int n) {
		for (int i = 0; i < n; i++) {
			for (int j = n; j >= i; j--) {
				System.out.print(" ");
			}
			for (int j = 0; j < n; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}

	// hollow rhombus
	public static void pattern8(int n) {
		for (int i = 0; i < n; i++) {
			for (int j = n; j >= i; j--) {
				System.out.print(" ");
			}
			for (int j = 0; j < n; j++) {
				if (i == 0 || j == 0 || i == n - 1 || j == n - 1) {
					System.out.print("*");
				} else {
					System.out.print(" ");
				}
			}
			System.out.println();
		}
	}

	// diamond
	public static void pattern9(int n) {
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n - i; j++) {
				System.out.print(" ");
			}
			for (int j = 1; j <= (2 * i) - 1; j++) {
				System.out.print("*");
			}
			System.out.println();
		}

		for (int i = n; i >= 1; i--) {
			for (int j = 1; j <= n - i; j++) {
				System.out.print(" ");
			}
			for (int j = 1; j <= (2 * i) - 1; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}

	// number pyramid
	public static void pattern10(int n) {
		int num = 1;
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n - i; j++) {
				System.out.print(" ");
			}
			for (int j = 1; j <= (2 * i) - 1; j++) {
				System.out.print(num);
			}
			num++;
			System.out.println();
		}
	}

	// number pyramid 2
	public static void pattern11(int n) {
		for (int i = 0; i < n; i++) {

			// " "
			for (int j = 1; j < n - i; j++) {
				System.out.print(" ");
			}

			// "*"
			for (int j = 1; j <= i; j++) {
				System.out.print(i + " ");
			}

			System.out.println();

		}
	}

	// palindromic number pyramid
	public static void pattern12(int n) {
		for (int i = 1; i <= n; i++) {
			// " "
			for (int j = 1; j <=n-i; j++) {
				System.out.print(" ");
			}
			
			// num
			for(int j=i;j>=1;j--) {
				System.out.print(j);
			}
			
			// right triangle number
			for(int j=2;j<=i;j++) {
				System.out.print(j);
			}
			
			System.out.println();
		}
	}

	public static void main(String[] args) {

		int n = 5;
		patter1(n);
		System.out.println("------------------");
		pattern2(n);
		System.out.println("------------------");
		pattern3(n);
		System.out.println("------------------");
		pattern4(n);
		System.out.println("------------------");
		pattern5(n);
		System.out.println("------------------");
		pattern6(n);
		System.out.println("------------------");
		pattern7(n);
		System.out.println("------------------");
		pattern8(n);
		System.out.println("------------------");
		pattern9(n);
		System.out.println("------------------");
		pattern10(n);
		System.out.println("------------------");
		pattern11(n);
		System.out.println("------------------");
		pattern12(n);

	}

}
