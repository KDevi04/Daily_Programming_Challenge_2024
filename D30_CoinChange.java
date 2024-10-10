import java.util.Scanner;
import java.util.Arrays;

public class CoinChange {
    public static int coinChange(int[] coins, int amount) {
        // Array to store the minimum number of coins for each amount
        int[] dp = new int[amount + 1];
        
        // Fill the dp array with a large number (infinity equivalent)
        Arrays.fill(dp, amount + 1);
        
        // Base case: to make 0 amount, 0 coins are required
        dp[0] = 0;
        
        // Iterate through all amounts from 1 to 'amount'
        for (int i = 1; i <= amount; i++) {
            for (int coin : coins) {
                if (i - coin >= 0) {
                    // Update dp[i] by considering the current coin
                    dp[i] = Math.min(dp[i], dp[i - coin] + 1);
                }
            }
        }
        
        // If dp[amount] is still greater than amount, it means we cannot form that amount
        return dp[amount] > amount ? -1 : dp[amount];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        // Take input for the number of coins
        System.out.print("Enter the number of coin types: ");
        int n = sc.nextInt();
        
        // Take input for the coin denominations
        int[] coins = new int[n];
        System.out.print("Enter the coin denominations: ");
        for (int i = 0; i < n; i++) {
            coins[i] = sc.nextInt();
        }
        
        // Take input for the amount
        System.out.print("Enter the amount: ");
        int amount = sc.nextInt();
        
        // Call the coinChange function and print the result
        int result = coinChange(coins, amount);
        if (result == -1) {
            System.out.println("It's not possible to make the amount with the given coins.");
        } else {
            System.out.println("The minimum number of coins needed: " + result);
        }
        
        sc.close();
    }
}
