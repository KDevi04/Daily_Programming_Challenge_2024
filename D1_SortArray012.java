import java.util.Arrays;

public class SortArray012 {
    // Function to sort the array consisting of 0s, 1s, and 2s
    public static void sortArray(int[] arr) {
        int low = 0, mid = 0, high = arr.length - 1;
        
        while (mid <= high) {
            switch (arr[mid]) {
                case 0:
                    // Swap arr[low] and arr[mid] and increment both
                    int temp = arr[low];
                    arr[low] = arr[mid];
                    arr[mid] = temp;
                    low++;
                    mid++;
                    break;
                    
                case 1:
                    // If the element is 1, just move the mid pointer
                    mid++;
                    break;
                    
                case 2:
                    // Swap arr[mid] and arr[high] and decrement high
                    temp = arr[mid];
                    arr[mid] = arr[high];
                    arr[high] = temp;
                    high--;
                    break;
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = {0, 1, 2, 1, 0, 2, 1, 0};
        System.out.println("Original Array: " + Arrays.toString(arr));
        
        sortArray(arr);
        
        System.out.println("Sorted Array: " + Arrays.toString(arr));
    }
}
