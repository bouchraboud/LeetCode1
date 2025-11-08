class Solution {
    public int search(int[] nums, int target) {
        int l = 0, r = nums.length - 1;

        while (l <= r) {
            int mid = l + (r - l) / 2;

            if (nums[mid] == target) return mid;

            // Check if the left half [l..mid] is sorted
            if (nums[l] <= nums[mid]) {
                // Target is in the left half
                if (nums[l] <= target && target < nums[mid]) {
                    r = mid - 1;
                } else { // Target in right half
                    l = mid + 1;
                }
            } 
            // Otherwise, the right half [mid..r] must be sorted
            else {
                if (nums[mid] < target && target <= nums[r]) {
                    l = mid + 1;
                } else {
                    r = mid - 1;
                }
            }
        }

        return -1;
    }
}
