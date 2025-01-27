import java.util.Arrays;

public class CoinChange {
    public static int coinChange(int[] coins, int amount) {
        // Array to store the minimum coins required for every amount from 0 to amount
        int[] dp = new int[amount + 1];
        // Fill dp array with a large value (amount + 1 is effectively "infinity" for this problem)
        Arrays.fill(dp, amount + 1);
        // Base case: 0 coins are needed to make up amount 0
        dp[0] = 0;

        // Iterate over each amount from 1 to 'amount'
        for (int i = 1; i <= amount; i++) {
            // Try every coin denomination
            for (int coin : coins) {
                if (i - coin >= 0) {
                    dp[i] = Math.min(dp[i], 1 + dp[i - coin]);
                }
            }
        }

        // If dp[amount] is still 'amount + 1', then it's impossible to make up that amount
        return dp[amount] == amount + 1 ? -1 : dp[amount];
    }

    public static void main(String[] args) {
        // Example 1
        int[] coins = {1, 2, 5};
        int amount = 11;
        System.out.println("Fewest coins needed: " + coinChange(coins, amount)); // Output: 3

        // Example 2
        coins = new int[]{2};
        amount = 3;
        System.out.println("Fewest coins needed: " + coinChange(coins, amount)); // Output: -1

        // Example 3
        coins = new int[]{1};
        amount = 0;
        System.out.println("Fewest coins needed: " + coinChange(coins, amount)); // Output: 0
    }
}
