import java.util.Stack;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {}

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

class Solution {
    public TreeNode recoverFromPreorder(String traversal) {
        Stack<TreeNode> stack = new Stack<>();
        int i = 0, n = traversal.length();

        while (i < n) {
            int depth = 0;

            // Calculate depth by counting dashes
            while (i < n && traversal.charAt(i) == '-') {
                depth++;
                i++;
            }

            // Parse the node value directly
            int val = 0;
            while (i < n && Character.isDigit(traversal.charAt(i))) {
                val = val * 10 + (traversal.charAt(i) - '0');
                i++;
            }

            // Adjust the stack to maintain the correct depth
            while (stack.size() > depth) {
                stack.pop();
            }

            // Create the new node
            TreeNode node = new TreeNode(val);

            // Attach it to the appropriate parent
            if (!stack.isEmpty()) {
                TreeNode parent = stack.peek();
                if (parent.left == null) {
                    parent.left = node;
                } else {
                    parent.right = node;
                }
            }

            // Push the current node onto the stack
            stack.push(node);
        }

        // The root of the tree is the first element added to the stack
        return stack.isEmpty() ? null : stack.firstElement();
    }
}
