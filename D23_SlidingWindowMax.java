import java.util.*;

public class SlidingWindowMaximum {

    public static List<Integer> maxSlidingWindow(int[] arr, int k) {
        List<Integer> result = new ArrayList<>();
        Deque<Integer> deque = new LinkedList<>();
        
        for (int i = 0; i < arr.length; i++) {
            // Remove elements out of the current window
            if (!deque.isEmpty() && deque.peekFirst() == i - k) {
                deque.pollFirst();
            }
            
            // Remove elements from the deque that are smaller than the current element
            while (!deque.isEmpty() && arr[deque.peekLast()] < arr[i]) {
                deque.pollLast();
            }
            
            // Add the current element at the back of the deque
            deque.offerLast(i);
            
            // Once the window has k elements, record the maximum (i.e., the front element of the deque)
            if (i >= k - 1) {
                result.add(arr[deque.peekFirst()]);
            }
        }
        
        return result;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Input array size
        System.out.print("Enter the size of the array: ");
        int n = scanner.nextInt();
        
        // Input array elements
        int[] arr = new int[n];
        System.out.println("Enter the elements of the array:");
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }
        
        // Input window size k
        System.out.print("Enter the window size k: ");
        int k = scanner.nextInt();
        
        // Get the sliding window maximums
        List<Integer> result = maxSlidingWindow(arr, k);
        
        // Output the result
        System.out.println("Maximums for each sliding window of size " + k + ": " + result);
        
        scanner.close();
    }
}
