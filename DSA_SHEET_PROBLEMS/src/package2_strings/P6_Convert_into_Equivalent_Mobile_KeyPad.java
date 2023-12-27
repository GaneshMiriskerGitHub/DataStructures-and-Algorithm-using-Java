package package2_strings;

public class P6_Convert_into_Equivalent_Mobile_KeyPad {
	
	static String keyPad[]
            = { "2", "22",  "222", "3",   "33", "333",
                    "4",    "44",  "444", "5",   "55", "555",
                    "6",    "66",  "666", "7",   "77", "777",
                    "7777", "8",   "88",  "888", "9",  "99",
                    "999",  "9999" };
	
	public static void printKeyPad(String str) {
		
		StringBuilder sb = new StringBuilder("");
		for(int i=0;i<str.length();i++) {
			char ch = str.charAt(i);
			if(ch == ' ') {
				sb.append("0");
			}else {
				int index = ch-'A';
				sb.append(keyPad[index]);
			}
		}
		
		System.out.println(sb.toString());
	}

	public static void main(String[] args) {
		
		String str = "HELLO WORLD";
		
		printKeyPad(str);

	}

}
