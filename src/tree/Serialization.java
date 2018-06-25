package tree;

public class Serialization {

    public static void main (String[] args) {
        TreeNode root = new TreeNode( "1" );
        root.left = new TreeNode( "2" );
        root.right = new TreeNode( "3" );
        root.right.left = new TreeNode( "4" );
        root.right.right = new TreeNode( "5" );

        String data = serialize( root );
        System.out.println(data);

        TreeNode tn = deserialize(data);
        System.out.println(tn.data);
        System.out.println(tn.left.data);
        System.out.println(tn.right.data);
    }

    public static String serialize(TreeNode root) {
        if (root == null)
            return "null,";

        StringBuilder sb = new StringBuilder();
        sb.append(root.data);
        sb.append(",");
        sb.append (serialize(root.left));
        sb.append(serialize(root.right));

        return sb.toString();
    }

    public static TreeNode deserialize(String data) {
        String[] arr = data.split(",");
        int[] offset = {0};
        return deserialize(arr, offset);
    }

    private static TreeNode deserialize(String[] arr, int[] offset) {
        if (offset[0] >= arr.length || arr[offset[0]].equals("null")) {
            offset[0]++;
            return null;
        }

        TreeNode node = new TreeNode(arr[offset[0]]);
        offset[0]++;
        node.left = deserialize(arr, offset);
        node.right = deserialize(arr, offset);

        return node;
    }


    static class TreeNode {
        String data;
        TreeNode left;
        TreeNode right;
        TreeNode(String data) {
            this.data = data;
        }
    }

}
