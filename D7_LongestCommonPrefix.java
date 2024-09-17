import java.util.Scanner;
public class Main {
    public static String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        // Start with the first string in the array as the initial prefix
        String prefix = strs[0];

        // Compare the prefix with each string in the array
        for (int i = 1; i < strs.length; i++) {
            // Reduce the prefix until it matches the beginning of the current string
            while (strs[i].indexOf(prefix) != 0) {
                prefix = prefix.substring(0, prefix.length() - 1);

                // If the prefix becomes empty, there is no common prefix
                if (prefix.isEmpty()) {
                    return "";
                }
            }
        }
        return prefix;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Read the number of strings
        System.out.println("Enter the number of strings:");
        int n = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character

        String[] strs = new String[n];

        // Read the strings
        System.out.println("Enter the strings:");
        for (int i = 0; i < n; i++) {
            strs[i] = scanner.nextLine();
        }

        // Find and print the longest common prefix
        String result = longestCommonPrefix(strs);
        System.out.println("Longest Common Prefix: " + result);

        scanner.close();
    }
}
