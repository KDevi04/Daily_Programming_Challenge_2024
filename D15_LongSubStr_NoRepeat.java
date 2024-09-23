import java.util.HashMap;
import java.util.Scanner;

public class LongestSubstringWithoutRepeating {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Input: String S
        System.out.print("Enter the string: ");
        String s = scanner.nextLine();
        
        int result = lengthOfLongestSubstring(s);
        System.out.println("Length of the longest substring without repeating characters: " + result);
    }

    public static int lengthOfLongestSubstring(String s) {
        HashMap<Character, Integer> charIndexMap = new HashMap<>();
        int maxLength = 0;
        int left = 0;

        for (int right = 0; right < s.length(); right++) {
            char currentChar = s.charAt(right);

            // If the character is already in the substring, move the left pointer
            if (charIndexMap.containsKey(currentChar)) {
                left = Math.max(charIndexMap.get(currentChar) + 1, left);
            }

            // Update the last seen index of the character
            charIndexMap.put(currentChar, right);
            // Calculate the length of the current substring
            maxLength = Math.max(maxLength, right - left + 1);
        }
        
        return maxLength;
    }
}
