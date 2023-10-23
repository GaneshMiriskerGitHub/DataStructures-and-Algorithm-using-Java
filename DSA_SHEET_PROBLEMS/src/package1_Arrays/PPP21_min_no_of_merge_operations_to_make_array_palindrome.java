package package1_Arrays;

public class PPP21_min_no_of_merge_operations_to_make_array_palindrome {
	
	public static int minMergesToPalindrome(int[] arr) {
		
		if(arr.length == 0 || arr.length == 1){
			return 0;
		}
		
		if(arr.length == 2) {
			if(arr[0] == arr[1]) {
				return 0;
			}else {
				return 1;
			}
		}
		
		int s = 0;
		int e = arr.length-1;
		int ans = 0;
		while(s<=e) {
			if(arr[s] == arr[e]) {
				s++;
				e--;
			}else if(arr[s] > arr[e]) {
				arr[e-1] += arr[e];
				e--;
				ans++;
			}else {
				arr[s+1] += arr[s];
				s++;
				ans++;
			}
		}
		
		return ans;
		
	}

	public static void main(String[] args) {
		
		int[] arr = {1, 4, 5, 9, 1};
		
		System.out.println(minMergesToPalindrome(arr));

	}

}
