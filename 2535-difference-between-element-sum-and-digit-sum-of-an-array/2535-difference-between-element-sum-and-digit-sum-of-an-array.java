class Solution {
    public int differenceOfSum(int[] nums) {
        int sum=0;
        int digitSum=0;
        for(int i=0;i<nums.length;i++){
            sum+=nums[i];
            String cur=Integer.toString(nums[i]);
            int j=0;
            while(j<cur.length()){
                digitSum+=cur.charAt(j)-'0';
                j++;
            }

        }
        return Math.abs(sum-digitSum);
        
    }
}