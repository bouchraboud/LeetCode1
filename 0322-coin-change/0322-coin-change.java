class Solution {
    int[] memo;

    public int coinChange(int[] coins, int amount) {
        if (amount == 0) return 0;
        Arrays.sort(coins);
        memo = new int[amount + 1];
        for (int i = 0; i <= amount; i++) {
            memo[i] = -2; // uncomputed
        }

        return dp(0, amount, coins);
    }

    private int dp(int sum, int amount, int[] coins) {
        if (sum == amount) return 0;
        if (memo[sum] != -2) return memo[sum];

        int min = Integer.MAX_VALUE;

        for (int i=coins.length-1;i>=0 ;i--) {
            int coin=coins[i];
            // ✅ overflow-safe check
            if (coin > amount - sum) continue;

            int res = dp(sum + coin, amount, coins);
            if (res != -1) {
                min = Math.min(min, 1 + res);
            }
        }

        memo[sum] = (min == Integer.MAX_VALUE) ? -1 : min;
        return memo[sum];
    }
}
