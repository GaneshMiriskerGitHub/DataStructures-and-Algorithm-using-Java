package package5_BackTracking;

public class Tester {
	
	public static void combinationalSum(int[] arr, int target, int sumAdded) {
		
		if(sumAdded == target) {
			System.out.println();
		}
		
		for(int i=0;i<arr.length;i++) {
			combinationalSum(arr, target, sumAdded+arr[i]);
		}
		
	}

	public static void main(String[] args) {
		
		int[] arr = {2, 4, 6, 8};
		int target = 8;
		
		combinationalSum(arr, target);

	}

}
