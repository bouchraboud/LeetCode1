class Solution {
    public boolean canPartition(int[] nums) {
        int n = nums.length;
        int sum = 0;
        for (int x : nums) sum += x;

        if (sum % 2 == 1) return false;
        int half = sum / 2;

        Boolean[][] memo = new Boolean[n][half + 1];
        return helper(nums, n - 1, 0, half, memo);
    }

    private boolean helper(int[] nums, int i, int sum, int half, Boolean[][] memo) {
        if (sum == half) return true;
        if (sum > half || i < 0) return false;

        if (memo[i][sum] != null) return memo[i][sum];

        boolean take = helper(nums, i - 1, sum + nums[i], half, memo);
        boolean skip = helper(nums, i - 1, sum, half, memo);

        return memo[i][sum] = take || skip;
    }
}
