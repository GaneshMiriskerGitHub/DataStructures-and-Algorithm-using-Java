package packagee11_Stacks;

import java.util.Arrays;
import java.util.Stack;

public class PP11_Max_Area_Rectangle {
	
	public static void maxRectangleArea(int[] arr) {
		int[] prevSmaller = P8_Next_Greater_Element.prevSmaller(arr);
		int[] nextSmaller = P8_Next_Greater_Element.nextSmaller(arr);
		
		int max = Integer.MIN_VALUE;
		for(int i=0;i<arr.length;i++) {
			int curr = (nextSmaller[i]-prevSmaller[i]-1) * arr[i];
			max = Math.max(max, curr);
		}
		
		System.out.println(max);
	}

	public static void main(String[] args) {
		
		int[] arr = {2, 1, 5, 6, 2, 3};
		
		maxRectangleArea(arr);

	}

}
