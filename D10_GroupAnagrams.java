import java.util.*;

public class GroupAnagrams {
    public List<List<String>> groupAnagrams(String[] strs) {
        // HashMap to store sorted string as key and list of anagrams as value
        Map<String, List<String>> map = new HashMap<>();

        // Iterate over each string in the array
        for (String s : strs) {
            // Convert string to char array and sort it
            char[] chars = s.toCharArray();
            Arrays.sort(chars);
            // Convert sorted char array back to string
            String sortedString = new String(chars);
            
            // If sortedString is not in map, create a new list
            if (!map.containsKey(sortedString)) {
                map.put(sortedString, new ArrayList<>());
            }
            // Add the original string to the list corresponding to the sorted string
            map.get(sortedString).add(s);
        }
        
        // Return all the values (grouped anagrams) as a list of lists
        return new ArrayList<>(map.values());
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Take input from user
        System.out.println("Enter strings separated by spaces:");
        String input = scanner.nextLine();
        
        // Split the input by spaces to get individual strings
        String[] strs = input.split(" ");
        
        GroupAnagrams solution = new GroupAnagrams();
        List<List<String>> result = solution.groupAnagrams(strs);
        
        // Printing the grouped anagrams
        System.out.println("Grouped Anagrams:");
        for (List<String> group : result) {
            System.out.println(group);
        }
        
        scanner.close();
    }
}
