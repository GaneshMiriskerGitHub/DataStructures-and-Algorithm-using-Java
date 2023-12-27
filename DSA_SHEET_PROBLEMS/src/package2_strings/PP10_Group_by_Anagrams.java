package package2_strings;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PP10_Group_by_Anagrams {
	
	public static List<List<String>> groupAnagrams(String[] str) {
		Map<String , List<String>> map = new HashMap<>();

		for(String word : str) {
			char[] currArr = word.toCharArray();
			Arrays.sort(currArr);
			String sortedWord = new String(currArr);
			if(!map.containsKey(sortedWord)) {
				map.put(sortedWord, new ArrayList<>());
			}
			map.get(sortedWord).add(word);
		}
		
		
		return new ArrayList<>(map.values());
	}

	public static void main(String[] args) {
		
		String[] str = {"eat","tea","tan","ate","nat","bat"};
		
		groupAnagrams(str);

	}

}
