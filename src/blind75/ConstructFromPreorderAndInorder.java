package blind75;

import java.util.HashMap;
import java.util.Map;

public class ConstructFromPreorderAndInorder {
    Map<Integer, Integer> inorderMap = new HashMap<>();
    int preOrderIndex = 0;

    public TreeNode buildTree(int[] preorder, int[] inorder) {

        for (int i = 0; i < inorder.length; i++) {
            inorderMap.put(inorder[i], i);
        }

        return buildTree(preorder, inorder, 0, inorder.length - 1);
    }

    public TreeNode buildTree(int[] preorder, int[] inorder, int start, int end) {

        if (start > end)
            return null;

        int rootValue = preorder[preOrderIndex++];
        TreeNode root = new TreeNode(rootValue);

        if (root == null)
            return root;

        int rootIndex = inorderMap.get(rootValue);
        root.left = buildTree(preorder, inorder, start, rootIndex - 1);
        root.right = buildTree(preorder, inorder, rootIndex + 1, end);

        return root;
    }
}
