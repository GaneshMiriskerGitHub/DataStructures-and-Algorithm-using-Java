package packagee1Pattern;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Tester {

	

	public static void main(String[] args) {

		int[] arr = new int[5];
		
		arr[0] = 1;
		arr[1] = 2;
		arr[2] = 3;
		arr[3] = 4;
//  	 0  1  2  3  4
	//  [1][2][3][4][]
		int position = 2;
		int num = 34;
		
		System.out.println(Arrays.toString(arr));
		
		
		for(int i=4;i>=3;i--) {
			arr[i] = arr[i-1];
		}
		
		arr[position] = num;
		
		System.out.println(Arrays.toString(arr));

	}

}
