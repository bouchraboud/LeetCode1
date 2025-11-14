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
    int max=0;
    public int diameterOfBinaryTree(TreeNode root) {
        if(root==null) return 0;
        Helper(root);
        return max;
    }
    private int  Helper(TreeNode root){

          if(root==null) return 0;
           int left=Helper(root.left);
           int right=Helper(root.right);
           int currPath=right+left;

           if(currPath>max) max=currPath;

          return 1+Math.max(right,left);

    }
}
