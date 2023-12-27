package package9_ArrayList;

import java.util.List;

public class P1_Container_with_most_water {

	
	// Brute Force
	public static int maxVal(List<Integer> list) {

		int max = 0;
		for (int i = 0; i < list.size(); i++) {
			for (int j = i; j < list.size(); j++) {
				int width = j - i;
				int min = Math.min(list.get(i), list.get(j));
				int currWater = width * min;
				max = Math.max(max, currWater);
			}
		}

		return max;
	}
	
	
	// 2-pointer approach
	public static int maxArea(int[] height) {
        int leftPointer = 0;
        int rightPointer = height.length-1;

        int maxContainer = Integer.MIN_VALUE;

        while(leftPointer < rightPointer){
            int minHeight = Math.min(height[leftPointer],height[rightPointer]);
            int width = rightPointer - leftPointer;

            int waterCovered = minHeight*width;

            maxContainer = Math.max(waterCovered, maxContainer);

            if(height[leftPointer] < height[rightPointer]){
                leftPointer++;
            }else{
                rightPointer--;
            }
        }

        return maxContainer;
    }

	public static void main(String[] args) {

		List<Integer> list = List.of(1,8,6,2,5,4,8,3,7);

		System.out.println(maxVal(list));

	}

}
