class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();

        for (int num : nums) {
           set.add(num);
        }
        int max=0;
        int currLength;
        for (Integer item : new HashSet<>(set)) {  
             currLength = 1;
             int right = item;
            int left = item;
            set.remove(item);
    
         while (set.contains(++right)) {
               currLength++;
               set.remove(right);
          }
         while (set.contains(--left)) {
               currLength++;
               set.remove(left);
          }
         if (currLength > max) {
             max = currLength;
        }
      }

        return max;

        
    }
}
