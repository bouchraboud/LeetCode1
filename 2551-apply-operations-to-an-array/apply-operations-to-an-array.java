class Solution {
    public int[] applyOperations(int[] nums) {
        int[] result=new int[nums.length];
        int k=0;
        for(int i=0;i<nums.length;i++){
            
            if(i<nums.length-1 &&nums[i]!=0&&nums[i]==nums[i+1]){
                result[k]=nums[i]*2;
                k++;
                i++;
                
            }else{
                if(nums[i]!=0){
                result[k]=nums[i];
                k++;}
            }
           

        }
        
        return result;
    }
}