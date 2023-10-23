package package3_String;

public class P4_Convert_To_UpperCase {
	
	public static void converToUpperCase(String str) {
		
		StringBuilder sb = new StringBuilder("");
		for(int i=0;i<str.length();i++) {
			char ch = str.charAt(i);
			if(i==0) {
				sb.append(Character.toUpperCase(ch));
			}else {
				if(str.charAt(i-1) == ' ') {
					sb.append(Character.toUpperCase(ch));
				}else {
					sb.append(ch);
				}
			}
		}
		
		System.out.println(sb.toString());
		
		str = sb.toString();
		
	}

	public static void main(String[] args) {
		
		String str = "hi, i am no:1";
		
		converToUpperCase(str);

	}

}
 