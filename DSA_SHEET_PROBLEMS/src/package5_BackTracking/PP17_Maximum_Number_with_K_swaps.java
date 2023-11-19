package package5_BackTracking;

public class PP17_Maximum_Number_with_K_swaps {

    public static String max;

    public static String maxNumberByKSwaps(String str, int k) {
        if (k == 0) {
            if (max == null || str.compareTo(max) > 0) {
                max = str;
            }
            return max;
        }

        for (int i = 0; i < str.length(); i++) {
            for (int j = i + 1; j < str.length(); j++) {
                if (str.charAt(i) < str.charAt(j)) {
                    str = swap(str, i, j);
                    maxNumberByKSwaps(str, k - 1);
                    str = swap(str, i, j);
                }
            }
        }

        return max;
    }

    public static String swap(String str, int i, int j) {
        char ith = str.charAt(i);
        char jth = str.charAt(j);

        StringBuilder sb = new StringBuilder(str);
        sb.setCharAt(i, jth);
        sb.setCharAt(j, ith);

        return sb.toString();
    }

    public static void main(String[] args) {
        String num = "1234567";
        int k = 3;
        maxNumberByKSwaps(num, k);

        System.out.println(max); // Output: "7554111527"
    }
}
