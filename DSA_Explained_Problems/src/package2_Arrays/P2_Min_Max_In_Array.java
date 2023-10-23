package package2_Arrays;

public class P2_Min_Max_In_Array {
	
	
	public static void minMax(int[] arr) {
		int min = Integer.MAX_VALUE;
		int max = Integer.MIN_VALUE;
		
		for(int i=0;i<arr.length;i++) {
			min = Math.min(arr[i], min);
			max = Math.max(arr[i], max);
		}
		
		System.out.println("min : "+min);
		System.out.println("max : "+max);
	}

	public static void main(String[] args) {
		
		int[] arr = {1, 2, 3, 4, 5};
		
		minMax(arr);

	}

}
