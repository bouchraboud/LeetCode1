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
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> list=new ArrayList<Integer>();
        
        if(root==null) return list;
        Queue<TreeNode> queue=new LinkedList<TreeNode>();

        queue.add(root);

        while(!queue.isEmpty()){
              
               int n=queue.size();
               int visibleElement=0;
               for(int i=0;i<n;i++){
                    TreeNode node =queue.poll();
                    visibleElement=node.val;
                    if (node.left != null) queue.add(node.left);
                    if (node.right != null) queue.add(node.right);

               }
               list.add(visibleElement);
        }
        return list;


        
    }
}

        
    