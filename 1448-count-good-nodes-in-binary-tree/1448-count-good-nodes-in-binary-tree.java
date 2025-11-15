class Solution {
    public int goodNodes(TreeNode root) {
        if (root == null) return 0;

        Stack<Pair<TreeNode, Integer>> stack = new Stack<>();
        stack.push(new Pair<>(root, root.val));
        int res = 0;

        while (!stack.isEmpty()) {
            Pair<TreeNode, Integer> current = stack.pop();
            TreeNode node = current.getKey();
            int maxSoFar = current.getValue();

            if (node.val >= maxSoFar) {
                res++;
            }

            int newMax = Math.max(maxSoFar, node.val);

            // Push non-null children only
            if (node.left != null) {
                stack.push(new Pair<>(node.left, newMax));
            }
            if (node.right != null) {
                stack.push(new Pair<>(node.right, newMax));
            }
        }

        return res;
    }
}
