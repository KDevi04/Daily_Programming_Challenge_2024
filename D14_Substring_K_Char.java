import java.util.HashMap;
import java.util.Scanner;

public class CountSubstringsWithKDistinct {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Input: String and integer k
        System.out.print("Enter the string: ");
        String s = scanner.nextLine();
        System.out.print("Enter the value of k: ");
        int k = scanner.nextInt();
        
        int result = countSubstringsWithKDistinct(s, k);
        System.out.println("Number of substrings with exactly " + k + " distinct characters: " + result);
    }

    public static int countSubstringsWithKDistinct(String s, int k) {
        return atMostKDistinct(s, k) - atMostKDistinct(s, k - 1);
    }

    private static int atMostKDistinct(String s, int k) {
        if (k <= 0) return 0;

        HashMap<Character, Integer> charCount = new HashMap<>();
        int left = 0, count = 0;

        for (int right = 0; right < s.length(); right++) {
            charCount.put(s.charAt(right), charCount.getOrDefault(s.charAt(right), 0) + 1);

            while (charCount.size() > k) {
                charCount.put(s.charAt(left), charCount.get(s.charAt(left)) - 1);
                if (charCount.get(s.charAt(left)) == 0) {
                    charCount.remove(s.charAt(left));
                }
                left++;
            }

            count += (right - left + 1);
        }
        
        return count;
    }
}
