class Solution {
    public int subarraySum(int[] nums, int k) {
        int result=0;
        for(int i=1;i<nums.length;i++){
            nums[i]=nums[i]+nums[i-1];
        }
       

        for(int i=0;i<nums.length;i++){
            for(int j=i;j<nums.length;j++){
                if(i==0){
                    
                    if(nums[j]==k) {
                       
                        result++;}
                }else{

                    if(nums[j]-nums[i-1]==k){
                   
                      result++;}
                }
            }
        }
        return result;
    }
}