class Solution {
    List<List<Integer>> res;
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        res = new ArrayList<List<Integer>>();
        List<Integer> cur = new ArrayList();
        Arrays.sort(candidates);
        backtrack(candidates, target, cur, 0);
        return res;
    }

    public void backtrack(int[] nums, int target, List<Integer> cur, int i) {
        if (target == 0) {
            res.add(new ArrayList(cur));
            return;
        }
        if (target < 0 || i >= nums.length) {
            return;
        }

        cur.add(nums[i]);//include
        backtrack(nums, target - nums[i], cur, i+1);

        cur.remove(cur.size() - 1);//exclude
        while(i+1<nums.length&&nums[i+1]==nums[i]){
            i++;
        }
        backtrack(nums, target, cur, i+1);
    }
}

