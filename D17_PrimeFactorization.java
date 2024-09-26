import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PrimeFactorization {

    // Method to perform prime factorization
    public static List<Integer> primeFactors(int n) {
        List<Integer> factors = new ArrayList<>();
        
        // Divide N by 2 until it becomes odd
        while (n % 2 == 0) {
            factors.add(2);
            n /= 2;
        }

        // Check for odd factors starting from 3
        for (int i = 3; i * i <= n; i += 2) {
            while (n % i == 0) {
                factors.add(i);
                n /= i;
            }
        }

        // If N is a prime number and greater than 2
        if (n > 2) {
            factors.add(n);
        }
        
        return factors;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        // Input
        System.out.print("Enter the value of N: ");
        int N = sc.nextInt();
        
        // Calculate prime factors
        List<Integer> result = primeFactors(N);
        
        // Output
        System.out.println("Prime factors: " + result);
    }
}
