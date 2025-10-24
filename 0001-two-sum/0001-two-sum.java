class Solution {
    public int[] twoSum(int[] nums, int target) {
       Map<Integer,Integer> map=new HashMap<Integer,Integer>();
         Map<Integer,Integer> mapDup=new HashMap<Integer,Integer>();

          for(int i=0;i<nums.length;i++){
            if(map.containsKey(nums[i])){
                if(2*nums[i]==target) return new int[]{map.get(nums[i]),i};
            }
            int val=nums[i];
            int sub=target-val;
            map.put(val,i);
            mapDup.put(sub,i);
            if(mapDup.containsKey(val)&&mapDup.get(val)!=i) return new int[]{mapDup.get(val),i};
            if(map.containsKey(sub)&&map.get(sub)!=i ) return new int[]{map.get(sub),i};


          }

          return new int[2];  
    }
}