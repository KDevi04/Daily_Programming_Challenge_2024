import java.util.Scanner;

public class LCMCalculator {

    // Method to calculate GCD using Euclidean algorithm
    public static int gcd(int a, int b) {
        if (b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }

    // Method to calculate LCM
    public static long lcm(int n, int m) {
        return ((long)n * m) / gcd(n, m);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        // Input
        System.out.print("Enter the value of N: ");
        int N = sc.nextInt();
        System.out.print("Enter the value of M: ");
        int M = sc.nextInt();
        
        // Calculate LCM
        long result = lcm(N, M);
        
        // Output
        System.out.println("The LCM of " + N + " and " + M + " is: " + result);
    }
}
