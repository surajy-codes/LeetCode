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
    int val=0;
    public boolean isUnivalTree(TreeNode root) {
        val=root.val;
        return f(root);
    }
    boolean f(TreeNode root){
        if(root==null) return true;
        if(root.val!=val) return false;
        return f(root.left)&&f(root.right);
    }
}