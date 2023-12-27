package package1_Arrays;

import java.util.Arrays;
import java.util.Comparator;

public class PPP22_Array_of_Numbers_to_Form_Bigggest_Number {
	
	public static String biggestNumber(int[] nums) {
		
		String[] arr = new String[nums.length];

        for(int i=0; i<nums.length; i++) {
            arr[i] = String.valueOf(nums[i]);
        }

        Arrays.sort(arr, new Comparator<String>() {
            @Override
            public int compare(String s1, String s2) {
                String n1 = s1 + s2, n2 = s2 + s1;
                return n2.compareTo(n1);
            }
        });

        if(arr[0].equals("0")) return "0";

        StringBuilder sb = new StringBuilder();
        for(String s : arr) {
            sb.append(s);
        }

        return sb.toString();
		
	}

	public static void main(String[] args) {
		
		int[] arr = {54, 546, 548, 60};
		
		System.out.println(biggestNumber(arr));

	}

}
