package blind75;


public class KthSmallestBST {
    int result = -1;
    int count = 0;
    int solution(TreeNode t, int k) {
        dfs(t, k);
        return result;
    }
    void dfs(TreeNode node, int k) {
        if (node == null) return;
        dfs(node, k);
        count++;
        if (count == k) {
            result = node.val;
            return;
        }
        dfs(node.right, k);
    }

}
