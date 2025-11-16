/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Solution {
    public int kthSmallest(TreeNode root, int k) {
       
       List<Integer> result = new ArrayList<>();
       Stack<TreeNode> stack = new Stack<>();
       TreeNode curr = root;
    
      while (curr != null || !stack.isEmpty()) {
        
        // Phase 1: Go left as deep as possible
         while (curr != null) {
            stack.push(curr);
            curr = curr.left;
         }
        
        // Phase 2: Visit the node (we've gone as far left as possible)
        curr = stack.pop();
        result.add(curr.val);
        if(result.size()==k) return result.get(k-1);
        
        // Phase 3: Go right
         curr = curr.right;
      }
    
         return result.get(k-1);
   }
}

