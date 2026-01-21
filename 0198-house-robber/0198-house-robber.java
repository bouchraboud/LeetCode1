class Solution {
    public int rob(int[] nums) {
        int n=nums.length;
        int[] memo=new int[n];
        Arrays.fill(memo, -1);
        if(n==1) return nums[0];
        return Math.max(helper(n-1,nums,memo),helper(n-2,nums,memo));
        
    }
    private int helper(int n,int[]nums,int[] memo){
        if(n<0) return 0;
        if(n==1) return nums[1];
        if(n==0) return nums[0];

        if(memo[n]==-1)
        memo[n]=nums[n]+Math.max(helper(n-2,nums,memo),helper(n-3,nums,memo));
        
        return memo[n];
    }
}
