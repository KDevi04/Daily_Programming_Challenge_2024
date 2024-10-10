import java.util.Scanner;

public class FibonacciDP {
    // Function to calculate the nth Fibonacci number using Dynamic Programming
    public static int fibonacci(int n) {
        // If n is 0, the Fibonacci number is 0
        if (n == 0) {
            return 0;
        }

        // If n is 1, the Fibonacci number is 1
        if (n == 1) {
            return 1;
        }

        // Create an array to store Fibonacci numbers up to n
        int[] fib = new int[n + 1];
        
        // Initial values for Fibonacci sequence
        fib[0] = 0;
        fib[1] = 1;

        // Fill the array with Fibonacci values up to n
        for (int i = 2; i <= n; i++) {
            fib[i] = fib[i - 1] + fib[i - 2];
        }

        // Return the n-th Fibonacci number
        return fib[n];
    }

    public static void main(String[] args) {
        // Create a scanner object to get user input
        Scanner scanner = new Scanner(System.in);

        // Read the integer input
        System.out.print("Enter a number (0 <= n <= 1000): ");
        int n = scanner.nextInt();

        // Calculate and print the nth Fibonacci number
        int result = fibonacci(n);
        System.out.println("The " + n + "-th Fibonacci number is: " + result);
    }
}
