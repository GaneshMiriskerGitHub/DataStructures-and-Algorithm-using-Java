package package3_String;

import java.util.Arrays;

public class Tester {
	
	public static void compressString(String str) {
		
		StringBuilder sb = new StringBuilder("");
		for(int i=0;i<str.length();i++) {
			char ch = str.charAt(i);
			int count = 1;
			while(i<str.length()-1 && ch == str.charAt(i+1)) {
				count++;
				i++;
			}
			if(count > 1) {
				sb.append(ch+""+count);
			}else {
				sb.append(ch);
			}
		}
		
		System.out.println(sb.toString());
		
	}
	
	 public static int compress(char[] chars) {
	        StringBuilder sb = new StringBuilder("");
	        for(int i=0;i<chars.length;i++) {
	            char ch = chars[i];
	            int count=1;
	            while(i<chars.length-1 && ch == chars[i+1]) {
	                count++;
	                i++;
	            }
	            if(count > 1) {
					sb.append(ch+""+count);
				}else {
					sb.append(ch);
				}
	        }

	        
	        String str = sb.toString();
	        System.out.println(str);
	        chars = str.toCharArray();
	        System.out.println(Arrays.toString(chars));

	        return chars.length;
	    }

	public static void main(String[] args) {
		
		String str = "aaabbbbcccdefghiii";
		
		compressString(str);
		
		char[] chars = {'a','a','b','b','c','c'};
		System.out.println(compress(chars));

	}

}
