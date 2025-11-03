class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> list=new ArrayList<List<Integer>>();
        int n=nums.length;
          Arrays.sort(nums);
        for(int i=0;i<n;i++){
                int k=n-1;
                for(int j=i+1;j<k;j++){
                       
                       while(k>j&&nums[i]+nums[j]+nums[k]>0){
                               k--;
                       }
                       if(k>j&&nums[i]+nums[j]+nums[k]==0){
                            if(!list.contains(new ArrayList<>(Arrays.asList(nums[i], nums[j], nums[k])))){
                                list.add(new ArrayList<>(Arrays.asList(nums[i], nums[j], nums[k])));
                            }

                       }

                }

        }
        return list;
    }
}
