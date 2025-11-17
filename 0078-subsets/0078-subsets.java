class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>>  result=new ArrayList<List<Integer>>();
         helper(nums, new ArrayList<>(),0, result);
        return result;
    }

    private void helper(int[] nums,List<Integer> current,int start ,List<List<Integer>> result){

            result.add(new ArrayList<>(current));
            
            for(int i=start;i<nums.length;i++){
                 current.add(nums[i]);                    // Include nums[i]
                 helper(nums,current, i + 1, result); // Recurse
                current.remove(current.size() - 1);      // Backtrack (exclude nums[i])
            }


    }
}
