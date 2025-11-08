class Solution {
    public int findMin(int[] nums) {
          
          int r=nums.length-1;
          int l=0;
          int result=nums[r];

        while(l<=r){
              int mid=(l+r)/2;

              if(nums[mid]>result){
                l=mid+1;

              }else{
                result=nums[mid];
                r=mid-1;
              }

        }
        return result;
    }
}
