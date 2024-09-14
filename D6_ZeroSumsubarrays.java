import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class ZeroSumsubarrays {
    
    // Function to find all subarrays with zero sum
    public static List<int[]> findZeroSumSubarrays(int[] arr) {
        // Create a list to store the result subarrays (start and end indices)
        List<int[]> result = new ArrayList<>();
        
        // HashMap to store the sum and its corresponding index
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        
        // Initialize the sum
        int sum = 0;
        
        // Add an initial entry to the map for sum 0 at index -1
        map.put(0, new ArrayList<>());
        map.get(0).add(-1);
        
        // Traverse the array
        for (int i = 0; i < arr.length; i++) {
            // Update the sum
            sum += arr[i];
            
            // If the sum is already present in the map, it means we have found subarrays with zero sum
            if (map.containsKey(sum)) {
                // Get the list of indices where the sum has occurred before
                List<Integer> indices = map.get(sum);
                for (Integer start : indices) {
                    // Add the subarray (start + 1, i) to the result list
                    result.add(new int[] {start + 1, i});
                }
            }
            
            // Add the current sum to the map
            map.putIfAbsent(sum, new ArrayList<>());
            map.get(sum).add(i);
        }
        
        return result;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Take input for the size of the array
        System.out.print("Enter the size of the array: ");
        int n = scanner.nextInt();
        
        // Take input for the array elements
        int[] arr = new int[n];
        System.out.println("Enter the elements of the array:");
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }
        
        // Call the function to find subarrays with zero sum
        List<int[]> result = findZeroSumSubarrays(arr);
        
        // Print the result
        if (result.isEmpty()) {
            System.out.println("No subarrays with zero sum found.");
        } else {
            System.out.println("Subarrays with zero sum:");
            for (int[] subarray : result) {
                System.out.println("Start index: " + subarray[0] + ", End index: " + subarray[1]);
            }
        }
        
        // Close the scanner
        scanner.close();
    }
}
