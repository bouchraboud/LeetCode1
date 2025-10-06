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

    public List<String> binaryTreePaths(TreeNode root) {
        List<String> answer = new ArrayList<String>();
        if (root != null)
            BTPaths(root, "", answer);
        return answer;
    }

    public void BTPaths(TreeNode root, String s, List<String> list) {
        if (root == null) {
            return;

        } else if (root.right == null && root.left == null) {
            System.out.println("iwa");
            System.out.println( root.val);
            s += root.val;
            list.add(s);
            System.out.println( s);
        } else {
            s += root.val + "->";
            BTPaths(root.right, s, list);
            BTPaths(root.left, s, list);

        }

    }

}