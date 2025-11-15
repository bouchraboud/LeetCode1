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
    public int goodNodes(TreeNode root) {
        Stack<Pair<TreeNode, Integer>> stack = new Stack<>();

        stack.push(new Pair<>(root, root.val));
        int res = 1;

        while (!stack.isEmpty()) {
            Pair<TreeNode, Integer> current = stack.pop();
            TreeNode node = current.getKey();
            int max = current.getValue();

            if (node != null) {
                if(node.left!=null&&node.left.val>=max){ stack.push(new Pair<>(node.left,node.left.val));res++;}
                else stack.push(new Pair<>(node.left,max));

                if(node.right!=null&&node.right.val>=max) {stack.push(new Pair<>(node.right,node.right.val)); res++;}
                else stack.push(new Pair<>(node.right,max));
            }
        }
        return res;
    }
}

