class Solution {
    public int maxAbsoluteSum(int[] nums) {
        int maxSum = 0, minSum = 0, currMax = 0, currMin = 0;

        for (int num : nums) {
            // Update current max and min sums
            currMax = Math.max(currMax + num, num);
            currMin = Math.min(currMin + num, num);

            // Update overall max and min sums
            maxSum = Math.max(maxSum, currMax);
            minSum = Math.min(minSum, currMin);
        }

        // Return the maximum absolute sum
        return Math.max(maxSum, Math.abs(minSum));
    }
}
