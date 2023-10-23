package package1_Arrays;

public class A2_Sorted_Rotated_Array {
	
	public static int search(int[] arr, int target) {
		
		int pivot = findPivot(arr);
		
		if(pivot == -1) {
			return binarySearch(arr,0, arr.length-1, target);
		}
		
		if(arr[pivot] == target) {
			return pivot;
		}
		
		if(target < arr[pivot]) {
			return binarySearch(arr, 0, pivot, target);
		}else {
			return binarySearch(arr, pivot+1, arr.length-1, target);
		}
		
	}
	
	public static int binarySearch(int[] arr, int s, int e, int target) {
		

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
	
	public static int findPivot(int[] arr) {
		int s = 0;
		int e = arr.length-1;
		
		while(s<=e) {
			int m = s+(e-s)/2;
			
			if( m<e &&  arr[m] > arr[m+1]) {
				return m;
			}
			if( m>s &&  arr[m-1] > arr[m]) {
				return m-1;
			}
			
			if(arr[s] <= arr[m]) {
				s=m+1;
			}else {
				e=m-1;
			}
		}
		
		return -1;
		
	}

	public static void main(String[] args) {
		
		int[] arr = {5, 6, 7, 8, 9, 10, 1, 2, 3};
		
		int target = 7;
		
		System.out.println(search(arr, target));

	}

}
