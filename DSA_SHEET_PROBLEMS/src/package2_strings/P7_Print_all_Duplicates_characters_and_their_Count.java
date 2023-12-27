package package2_strings;

import java.util.Arrays;

public class P7_Print_all_Duplicates_characters_and_their_Count {
	
	public static void printAllDuplicatesAndCount(String str) {
		
		char[] ch = str.toCharArray();
		
		Arrays.sort(ch);
	
		for(int i=0;i<ch.length;i++) {
			StringBuilder sb = new StringBuilder("");
			int count = 1;
			char curr = ch[i];
			while(i<ch.length-1 && curr == ch[i+1]) {
				count++;
				i++;
			}
			if(count > 1) {
				sb.append(curr+", count = "+count);
				System.out.println(sb.toString());
			}
		}
		
	}

	public static void main(String[] args) {
		
		String str = "test string";
		
		printAllDuplicatesAndCount(str);

	}

}
