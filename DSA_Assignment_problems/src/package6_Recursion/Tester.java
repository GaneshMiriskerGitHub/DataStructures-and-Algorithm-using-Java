package package6_Recursion;

public class Tester {
	
	/*
	 * print the count of substrings whose fisrt and last char is same
	 * 
	 */

	public static int printCountOfSubstrings(String str, int i, int j) {
		
		int count=0;
		
		if(i > j) {
			return count;
		}
		
		if(str.charAt(i) == str.charAt(j)) {
			count++;
		}
		count+=printCountOfSubstrings(str, i+1, j);
		count+=printCountOfSubstrings(str, i, j-1);
		count-=printCountOfSubstrings(str, i+1, j-1); // remark
		
		return count;
		
	}
	
	public static void main(String[] args) {
		
		String str = "abcab";
		
		System.out.println(printCountOfSubstrings(str, 0, str.length()-1));

	}

}
