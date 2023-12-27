package package2_String;

public class A1_Count_LowerCase_Vowels {
	
	public static void countLowerCaseVowels(String input) {
		int vowelCount = 0;

        // Convert the string to lowercase for consistent comparison
        input = input.toLowerCase();

        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') {
                vowelCount++;
            }
        }

        System.out.println("Total lowercase vowels: " + vowelCount);
	}

	public static void main(String[] args) {
		
		String input = "This is a sample string with some vowels.";
		
		
        countLowerCaseVowels(input);

	}

}
