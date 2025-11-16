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
    int indexRoot = 0; // Make this global to track position in preorder
    
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return helper(preorder, inorder, 0, inorder.length - 1);
    }

    private TreeNode helper(int[] preorder, int[] inorder, int left, int right) {
        
        // Base case
        if (left > right) return null;
        
        // Get current root from preorder and move to next
        int rootVal = preorder[indexRoot++];
        TreeNode node = new TreeNode(rootVal);
        
        // Find root position in inorder
        int i = left;
        while (inorder[i] != rootVal) {
            i++;
        }
        
        // Build left subtree first (preorder goes left before right)
        node.left = helper(preorder, inorder, left, i - 1);
        
        // Then build right subtree
        node.right = helper(preorder, inorder, i + 1, right);
        
        return node;
    }
}
