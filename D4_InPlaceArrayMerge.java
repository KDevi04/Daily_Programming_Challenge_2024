import java.util.Arrays;
import java.util.Scanner;

public class Main {

    public static void merge(int[] arr1, int m, int[] arr2, int n) {
        int i = m - 1;  // Pointer for the last element of arr1
        int j = 0;      // Pointer for the first element of arr2
        
        // Compare elements from the end of arr1 and the start of arr2
        // and swap if needed
        while (i >= 0 && j < n) {
            if (arr1[i] > arr2[j]) {
                // Swap the elements
                int temp = arr1[i];
                arr1[i] = arr2[j];
                arr2[j] = temp;
            }
            i--;
            j++;
        }

        // Sort both arrays to maintain sorted order
        Arrays.sort(arr1);
        Arrays.sort(arr2);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // User input for the first array
        System.out.print("Enter the size of the first array: ");
        int m = sc.nextInt();
        int[] arr1 = new int[m];
        System.out.println("Enter " + m + " elements for the first array:");
        for (int i = 0; i < m; i++) {
            arr1[i] = sc.nextInt();
        }

        // User input for the second array
        System.out.print("Enter the size of the second array: ");
        int n = sc.nextInt();
        int[] arr2 = new int[n];
        System.out.println("Enter " + n + " elements for the second array:");
        for (int i = 0; i < n; i++) {
            arr2[i] = sc.nextInt();
        }

        // Merge the arrays
        merge(arr1, m, arr2, n);

        // Output the merged arrays
        System.out.println("Merged first array: " + Arrays.toString(arr1));
        System.out.println("Merged second array: " + Arrays.toString(arr2));
    }
}
