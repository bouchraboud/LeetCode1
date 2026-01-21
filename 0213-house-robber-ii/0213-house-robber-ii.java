class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        if (n == 1) return nums[0];

        // Case 1: rob houses 0..n-2
        int[] memo1 = new int[n];
        Arrays.fill(memo1, -1);
        int case1 = robRange(nums, 0, n - 2, memo1);

        // Case 2: rob houses 1..n-1
        int[] memo2 = new int[n];
        Arrays.fill(memo2, -1);
        int case2 = robRange(nums, 1, n - 1, memo2);

        return Math.max(case1, case2);
    }

    private int robRange(int[] nums, int i, int end, int[] memo) {
        if (i > end) return 0;
        if (memo[i] != -1) return memo[i];

        memo[i] = Math.max(
            nums[i] + robRange(nums, i + 2, end, memo),
            robRange(nums, i + 1, end, memo)
        );
        return memo[i];
    }
}
