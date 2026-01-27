class Solution {

    public boolean canJump(int[] nums) {
        int memo[]=new int[nums.length];
        Arrays.fill(memo,-1);
        return dp(nums,0,memo);
        
    }

    private boolean dp(int[] nums,int i,int memo[]){
        if(i==nums.length-1) return true;
        if(nums[i]==0) return false;
        
        for(int j=1+i;j<=i+nums[i]&&j<nums.length;j++){
            boolean cur;
            if(memo[j]==-1){  
                cur=dp(nums,j,memo);
              if(cur==true) memo[j]=1;
              else memo[j]=0;
            }

            if(memo[j]==1) return true;
        }
        return false;
    }
}