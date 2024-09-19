import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class PermutationsOfString {
    
    // Method to find all permutations of the given string
    public static List<String> getPermutations(String str) {
        List<String> result = new ArrayList<>();
        // We use a set to avoid duplicate permutations
        Set<String> set = new HashSet<>();
        // Helper function to generate permutations
        permuteHelper(str, "", set);
        result.addAll(set); // Add unique permutations from set to list
        return result;
    }

    // Helper function for recursion
    private static void permuteHelper(String str, String perm, Set<String> set) {
        if (str.isEmpty()) {
            set.add(perm); // Add the complete permutation to the set
            return;
        }
        
        for (int i = 0; i < str.length(); i++) {
            // Recursively build the permutation
            permuteHelper(str.substring(0, i) + str.substring(i + 1), perm + str.charAt(i), set);
        }
    }

    public static void main(String[] args) {
        // Scanner to get user input
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter a string: ");
        String input = scanner.nextLine();
        
        // Get all permutations of the input string
        List<String> permutations = getPermutations(input);
        
        System.out.println("Permutations:"+permutations);
        
        scanner.close();
    }
}
