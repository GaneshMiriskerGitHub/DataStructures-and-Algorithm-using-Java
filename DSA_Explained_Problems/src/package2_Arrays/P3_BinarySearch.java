package package2_Arrays;

public class P3_BinarySearch {
	
	public static int binarySearch(int[] arr, int target) {
		int s = 0;
		int e = arr.length-1;
		
		while(s<=e) {
			int m = s+(e-s)/2;
			
			if(arr[m] == target) {
				return m;
			}
			
			if(target < arr[m]) {
				e = m-1;
			}else {
				s = m+1;
			}
		}
		
		return -1;
	}


	public static void main(String[] args) {
		
		int[] arr = {1, 2, 3, 4, 5, 6, 7, 8};
		int target = 5;
		
		System.out.println(binarySearch(arr, target));
		
	}

}
