package package4_Searching_and_Sorting;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class PPP23_Minimum_Number_Of_Swaps_to_Sort_an_Array {
	
	// learning: watch 1  :- https://www.youtube.com/watch?v=kFe_LRWuZjE
	// learning: watch 2  :- https://www.youtube.com/watch?v=02NwBUPr1uw
	

	public static void printMinSwaps(int[] arr) {
		
		int[] temp = Arrays.copyOfRange(arr, 0, arr.length);
		
		HashMap<Integer, Integer> map = new HashMap<>();
		for(int i=0;i<arr.length;i++) {
			map.put(arr[i], i);
		}
		
		Arrays.sort(temp);
		
		System.out.println(Arrays.toString(arr));
		
		int ans = 0;
		for(int i=0;i<temp.length;i++) {
			if(arr[i] != temp[i]) {
				ans++;
				int currArrEle = arr[i];
				swap(arr, i, map.get(temp[i]));
				
				map.put(currArrEle, map.get(temp[i]));
				map.put(temp[i], i);
			}
		}
		
		System.out.println("no of swaps = "+ans);

	}
	
	public static void swap(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}

	public static void main(String[] args) {

		int[] arr = { 101, 758, 315, 730, 472, 619, 460, 479 }; 

		printMinSwaps(arr);

	}

}
