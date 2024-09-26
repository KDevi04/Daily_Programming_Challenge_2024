import java.util.Scanner;

public class DivisorCount {

    // Method to count the total number of divisors
    public static int countDivisors(int n) {
        int count = 0;
        
        // Check divisors from 1 to the square root of n
        for (int i = 1; i * i <= n; i++) {
            if (n % i == 0) { // If i is a divisor
                count++; // Count i
                if (i != n / i) { // Count the corresponding divisor
                    count++;
                }
            }
        }
        
        return count;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        // Input
        System.out.print("Enter the value of N: ");
        int N = sc.nextInt();
        
        // Calculate total divisors
        int result = countDivisors(N);
        
        // Output
        System.out.println("Total number of divisors: " + result);
    }
}
