package package2_strings;

public class P4_Remove_Consecutive_Characters {
	
	public static String removeConsecutiveCharacters(String str) {
		
		StringBuilder sb = new StringBuilder("");
		for(int i=0;i<str.length();i++) {
			char ch = str.charAt(i);
			
			while(i<str.length()-1 && ch == str.charAt(i+1)) {
				i++;
			}
			sb.append(ch);
			
		}
		
		return sb.toString();
		
	}

	public static void main(String[] args) {
		
		String str = "aaabbbccdddaaabbb";
		
		System.out.println(removeConsecutiveCharacters(str));

	}

}
