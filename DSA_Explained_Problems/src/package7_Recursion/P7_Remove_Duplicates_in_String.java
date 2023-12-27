package package7_Recursion;

public class P7_Remove_Duplicates_in_String {
	
	//  iteration
	public static String removeDuplicates(String str) {
		
		boolean[] map = new boolean[26];
		
		StringBuilder newStr = new StringBuilder("");
		for(int i=0;i<str.length();i++) {
			if(map[str.charAt(i) - 'a'] == true) {
				continue;
			}else {
				newStr.append(str.charAt(i));
				map[str.charAt(i) - 'a'] = true;
			}
		}
		
		return newStr.toString();
		
	}
	
	//  recursion
	public static void removeDuplicatesRec(String str, boolean[] map, int i, StringBuilder newStr) {
		
		if(i == str.length()) {
			System.out.println(newStr.toString());
			return ;
		}
		
		if(map[str.charAt(i)-'a'] == true) {
			removeDuplicatesRec(str, map, i+1, newStr);
		}else {
			newStr.append(str.charAt(i));
			map[str.charAt(i)-'a'] = true;
			removeDuplicatesRec(str, map, i+1, newStr);
		}
		
	}

	public static void main(String[] args) {
		
		String str = "apnnaacollleggeee";
		
		removeDuplicatesRec(str, new boolean[26], 0, new StringBuilder(""));
		
//		System.out.println(newStr);
		
		
	}

}
