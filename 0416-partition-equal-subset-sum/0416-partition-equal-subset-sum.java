class Solution {
    public boolean canPartition(int[] nums) {
        int n=nums.length;
        int sum=0;

        for(int i=0;i<n;i++){
            sum+=nums[i];
        }
        if(sum%2==1) return false;
        int half=sum/2;


        return helper(nums,0,n-1,half);
        
    }

    private boolean helper(int[] nums,int sum ,int i,int half){
        if(sum==half) return true;
        if(sum>half||i<0) return false;

        return helper(nums,sum+nums[i],i-1,half)||helper(nums,sum,i-1,half);

    }
}
