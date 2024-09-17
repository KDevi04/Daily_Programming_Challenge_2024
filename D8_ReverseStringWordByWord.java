import java.util.Scanner;

public class ReverseWordsInString {
    public static String reverseWords(String s) {
        // Trim leading and trailing spaces and split the words by one or more spaces
        String[] words = s.trim().split("\\s+");
        
        // Use StringBuilder to reverse the words
        StringBuilder result = new StringBuilder();
        
        // Append words in reverse order
        for (int i = words.length - 1; i >= 0; i--) {
            result.append(words[i]);
            if (i != 0) {
                result.append(" ");
            }
        }
        
        return result.toString();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a string: ");
        String input = scanner.nextLine();
        
        String reversedString = reverseWords(input);
        System.out.println("Reversed words: " + reversedString);
    }
}
