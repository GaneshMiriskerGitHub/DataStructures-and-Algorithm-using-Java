package package6_Recursion;

public class P4_Array_is_Sorted_or_not {
	
	public static boolean isSorted(int[] arr, int i) {
		
		if(i == arr.length || i == arr.length-1) return true;
		
		if(arr[i] > arr[i+1]) return false;
		
		return isSorted(arr, i+1);
		
	}

	public static void main(String[] args) {
		
		int[] arr = {1, 2, 3, 4, 5};
		
		System.out.println(isSorted(arr, 0));

	}

}
