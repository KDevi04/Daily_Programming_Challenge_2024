import java.util.Scanner;
public class Main {

    public static String longestPalindrome(String s) {
        if (s == null || s.length() < 1) return "";
        
        int start = 0, end = 0;

        for (int i = 0; i < s.length(); i++) {
            // Case 1: Odd length palindrome (single character center)
            int len1 = expandAroundCenter(s, i, i);

            // Case 2: Even length palindrome (two characters center)
            int len2 = expandAroundCenter(s, i, i + 1);

            int len = Math.max(len1, len2);
            
            // Update the start and end if a longer palindrome is found
            if (len > end - start) {
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }

        return s.substring(start, end + 1);
    }

    // Helper function to expand around center and return the length of palindrome
    private static int expandAroundCenter(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        // The length of palindrome is (right - left - 1) because left and right exceed the palindrome bounds by 1
        return right - left - 1;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s1 = sc.nextLine();
        String s2 =longestPalindrome(s1);
        System.out.println(s2);
        }
}
