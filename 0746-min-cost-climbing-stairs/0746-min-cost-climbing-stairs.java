class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        int[] memo = new int[n];
        Arrays.fill(memo, -1);
        return Math.min(helper(cost, n-1, memo), helper(cost, n-2, memo));
    }

    private int helper(int[] cost, int i, int[] memo) {
        if (i == 0) return cost[0];
        if (i == 1) return cost[1];

        if (memo[i] != -1) return memo[i];

        memo[i] = cost[i] + Math.min(helper(cost, i-1, memo), helper(cost, i-2, memo));
        return memo[i];
    }
}
