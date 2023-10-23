package package2_Arrays;

public class P5_Pairs_In_Array {
	
	public static void printPairs(int[] arr) {
		
		for(int i=0;i<arr.length;i++) {
			for(int j=i;j<arr.length;j++) {
				System.out.print("("+arr[i]+", "+arr[j]+")");
				System.out.print(" ");
			}
			System.out.println();
		}
		
	}

	public static void main(String[] args) {
		
		int[] arr = {1, 2, 3, 4, 5};
		
		printPairs(arr);
		
	}

}
 