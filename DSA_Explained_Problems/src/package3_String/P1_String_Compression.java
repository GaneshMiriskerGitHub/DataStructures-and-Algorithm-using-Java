package package3_String;

public class P1_String_Compression {
	
	public static String stringCompression(String str) {
		
		StringBuilder sb = new StringBuilder("");
		for(int i=0;i<str.length();i++) {
			char ch = str.charAt(i);
			int count = 1;
			while( i<str.length()-1 &&  str.charAt(i) == str.charAt(i+1)) {
				count++;
				i++;
			}
			sb.append(ch+ "" +count);
		}
		
		return sb.toString();
	}

	public static void main(String[] args) {
		
		String str = "aaabbbcccd";
		
		System.out.println(stringCompression(str));

	}

}
