package package1_Arrays;

import java.util.HashMap;
import java.util.Map;

public class PPP23_Subarray_Divisible_By_K { // learnt directly from gfg code
	                                        // Link :- https://www.geeksforgeeks.org/longest-subarray-sum-divisible-k/
	
	// brute force 
	public static void maxLength(int[] arr, int k) {
		
		int max = 0;
		for(int i=0;i<arr.length;i++) {
			int currSum = 0;
			for(int j=i;j<arr.length;j++) {
				currSum += arr[j];
				if(currSum % k == 0) {
					max = Math.max(max, j-i+1);
				}
			}
		}
		
		System.out.println(max);
		
	}
	
	
	// optimised
	public static void maxLengthOptimised(int[] arr, int k) {
		
		int[] prefixSum = new int[arr.length];
		int sum = 0;
		for(int i=1;i<arr.length;i++) {
			prefixSum[i] = sum;
		}
		
		int[] mod_arr = new int[arr.length];
		sum = 0;
		for(int i=0;i<arr.length;i++) {
			// as the sum can be negative,
            // taking modulo twice
			sum += arr[i];
            mod_arr[i] = ((sum % k) + k) % k;
		}
		
		int max_len = 0;
		Map<Integer, Integer> um = new HashMap<>();
		for(int i=0;i<arr.length;i++) {
			if(mod_arr[i] == 0) {
				max_len = i+1;
			}
			
			if(!um.containsKey(mod_arr[i])) {
				um.put(mod_arr[i], i);
			}else {
				int sz = i-um.get(mod_arr[i]);
				max_len = Math.max(max_len, sz);
			}
		}
		
		System.out.println(max_len);
		
	}
	
	
	// gfg submission has to be done later :-
	int longSubarrWthSumDivByK(int a[], int n, int k)
    {
        // Complete the function
        int sum = 0;
        int max_len = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for(int i=0;i<a.length;i++) {
            sum+=a[i];
            int mod = ((sum % k) + k) % k;
            int prefixSum = sum;
            
            if(mod == 0) {
                max_len = i+1;
            }
            
            if(!map.containsKey(mod)) {
                map.put(mod, i);
            }else{
                int sz = i-map.get(mod);
                max_len = Math.max(max_len, sz);
            }
        }
        
        return max_len;
       
    }

	public static void main(String[] args) {
		
		int[] arr = { 2, 7, 6, 1, 4, 5 };
		
		maxLength(arr, 3);
		
		maxLengthOptimised(arr, 3);

	}

}
