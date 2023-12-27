package package5_BackTracking;

public class P6_Partition_Equal_SubSet_Sum {
	
	public static boolean partition(int[] arr) {
		
		int sum=0;
		for(int ele: arr) sum+=ele;
		
		int target = sum/2;
		
		if(sum%2!=0) return false;
		
		return findPartition(arr, target, 0);
		
	}
	
	
	
	public static boolean findPartition(int[] arr, int target, int i) {
		
		if(target == 0) {
			return true;
		}
		if(i==arr.length) {
			return false;
		}
		
		if(arr[i] <= target) {
			return findPartition(arr, target-arr[i], i+1) || findPartition(arr, target, i+1);
		}else {
			return findPartition(arr, target, i+1);
		}
		
	}

	public static void main(String[] args) {

		int arr[] = { 3, 1, 5, 9, 12 };
		int n = arr.length;

		System.out.println(partition(arr));

	}

}