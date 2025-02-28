class Solution {
    public int subarraySum(int[] nums, int k) {
        int result = 0;
        int sum=nums[0]; 
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(nums[0], 1);
        if (nums[0] == k)
            result++;
        for (int i = 1; i < nums.length; i++) {
             sum = nums[i] + sum; // Calculate sum of consecutive elements
            
            if (sum == k)
                result++;
            if (map.containsKey(sum - k)) {
                result += map.get(sum - k);

            }
            if (map.containsKey(sum)) {
                map.put(sum, map.get(sum) + 1); // Increment existing value
            } else {
                map.put(sum, 1); // Initialize new key with value 1
            }
        }
       
        return result;
    }
}