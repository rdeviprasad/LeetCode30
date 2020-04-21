/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode bstFromPreorder(int[] preorder) {
        TreeNode root = null;
        root = insert(root, preorder[0]);
        for(int i = 1; i < preorder.length; i++)
            insert(root, preorder[i]);
        return root;
    }
    private TreeNode insert(TreeNode root, int item) {
        TreeNode newNode = new TreeNode(item);
        TreeNode x = root;
        TreeNode y = null;
        while(x != null) {
            y = x;
            if(item < x.val) {
                x = x.left;
            } else {
                x = x.right;
            }
        }
        if(y == null) 
            y = newNode;
        else if( item < y.val) 
            y.left = newNode;
        else 
            y.right = newNode;
        return y;
    }
}