class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> result=new ArrayList<List<Integer>>();
        List<Integer> cur=new ArrayList<Integer>();
        Arrays.sort(nums);
        backtrack(nums,0,cur,result);
        return result;
    }

    private void backtrack(int[] nums ,int i ,List<Integer> cur,List<List<Integer>> result){

       

        if (i == nums.length) {
            result.add(new ArrayList<>(cur));
            return;
        }
        
        

        cur.add(nums[i]);
        backtrack(nums,i+1,cur,result);//include
        cur.remove(cur.size()-1);
        
        while (i + 1 < nums.length && nums[i] == nums[i + 1]) {
            i++;
        }
        backtrack(nums,i+1,cur,result);//excluse

    }
}
