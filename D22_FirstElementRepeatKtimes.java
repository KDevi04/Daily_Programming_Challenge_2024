import java.util.*;

public class FirstKOccurrences {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Taking input for array size
        int n = sc.nextInt();
        
        // Taking input for the array elements
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        // Taking input for the integer k
        int k = sc.nextInt();

        // A LinkedHashMap to store the frequency of each element
        Map<Integer, Integer> frequencyMap = new LinkedHashMap<>();

        // Populate the frequency map
        for (int num : arr) {
            frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
        }

        // Iterate through the array and return the first element with exactly k occurrences
        for (int num : arr) {
            if (frequencyMap.get(num) == k) {
                System.out.println(num);
                return;
            }
        }

        // If no element is found with exactly k occurrences, return -1
        System.out.println(-1);
    }
}
