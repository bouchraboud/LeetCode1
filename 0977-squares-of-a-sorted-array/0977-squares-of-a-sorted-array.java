class Solution {
    public int[] sortedSquares(int[] nums) {
        int n=nums.length;
        int i=0;
        int j=n-1;
        int[] result=new int[n];

        while(i<=j){
           int left=nums[i]*nums[i];
           int right=nums[j]*nums[j];
           if(left>right){
               result[j-i]=left;
               i++;
           }else{
               result[j-i]=right;
               j--;
           }
        }

        return result;
        
    }
}