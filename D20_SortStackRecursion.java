import java.util.Stack;
import java.util.Scanner;
public class SortStack {

    // Function to sort the stack
    public static void sortStack(Stack<Integer> stack) {
        // Base case: If the stack is empty, return
        if (stack.isEmpty()) {
            return;
        }

        // Remove the top element
        int top = stack.pop();
        // Recursively sort the remaining stack
        sortStack(stack);

        // Insert the top element back in the sorted stack
        insertSorted(stack, top);
    }

    // Helper function to insert an element in a sorted manner
    private static void insertSorted(Stack<Integer> stack, int element) {
        // Base case: If the stack is empty or the top element is smaller than or equal to the element
        if (stack.isEmpty() || stack.peek() <= element) {
            stack.push(element);
            return;
        }

        // Remove the top element
        int top = stack.pop();
        System.out.println(top);
        // Recursively insert the element in the sorted stack
        insertSorted(stack, element);

        // Push the removed element back
        stack.push(top);
    }

    // Driver function to test the sorting
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Stack<Integer> stack = new Stack<>();
        int size = sc.nextInt();
        for(int i=0;i<size;i++)
        {
            int num = sc.nextInt();
            stack.push(num);
        }

        System.out.println("Stack before sorting: " + stack);

        sortStack(stack);

        System.out.println("Stack after sorting: " + stack);
    }
}
