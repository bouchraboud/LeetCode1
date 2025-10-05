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
    public int minDepth(TreeNode root) {
        if (root == null) return 0;
        int depth = 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        

        while (!queue.isEmpty()) {
            depth++;

            var levelsize=queue.size();
            for (int i = 0; i < levelsize; i++) {
                TreeNode current = queue.poll();
                if (current.right == null && current.left == null)
                    return depth;
                if (current.right != null)
                    queue.offer(current.right); 
                if (current.left != null)
                    queue.offer(current.left); 
            }
        }
        return depth;
    }

    // public int minDepth(TreeNode root) {
    //     if(root==null){
    //         return 0;
    //     }
    //     if(root.left==null&&root.right!=null){
    //           return 1+minDepth(root.right);
    //     }
    //     if(root.right==null&&root.left!=null){
    //         return 1+minDepth(root.left);
    //     }
    //     return 1+(minDepth(root.left)<minDepth(root.right)?minDepth(root.left):minDepth(root.right));
    // }
}