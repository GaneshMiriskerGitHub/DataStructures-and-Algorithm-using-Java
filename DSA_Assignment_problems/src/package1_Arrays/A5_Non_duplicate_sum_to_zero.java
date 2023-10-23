package package1_Arrays;

import java.util.ArrayList;
import java.util.List;

public class A5_Non_duplicate_sum_to_zero {
	
	public static void findAllThreeElementsWithZeroSum(int[] arr) {
		
		List<List<Integer>> list = new ArrayList<>();
		
		for(int i=0;i<arr.length;i++) {
			for(int j=i+1;j<arr.length;j++) {
				for(int k=j+1;k<arr.length;k++) {
					List<Integer> subList = new ArrayList<>();
					if(arr[i]+arr[j]+arr[k] == 0) {
						subList.add(arr[i]);
						subList.add(arr[j]);
						subList.add(arr[k]);
						list.add(subList);
					}
				}
			}
		}
		
		System.out.println(list.toString());
		
	}

	public static void main(String[] args) {
		
		int[] arr = {0, -1, 2, -3, 1};
		
		findAllThreeElementsWithZeroSum(arr);

	}

}
