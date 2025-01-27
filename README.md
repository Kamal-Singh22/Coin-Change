# Coin-Change
You are given an integer array coins representing coin denominations and an integer amount representing a total amount of money.



Explanation:
Dynamic Programming Array (dp):

dp[i] represents the minimum number of coins needed to form the amount i.
Initialize all values in dp to a large number (amount + 1) because it's impossible to need more than amount coins to make up any amount.
Transition Formula:

For every amount i:
For every coin coin in the array:
If the current amount i is greater than or equal to coin, update dp[i] as:
dp[i] = min(dp[i], 1 + dp[i - coin])

Final Result:

If dp[amount] is still a large value, return -1 (not possible to form the amount).
Otherwise, return dp[amount].

Time Complexity:
O(n * m), where n is the amount and m is the number of coins.
Space Complexity:
O(n) for the dp array.
