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
    int max=Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        helper(root);
        return max;
    }
    int helper(TreeNode root){
        if(root==null) return 0;
        int l=helper(root.left);
        int r=helper(root.right);
        max=Math.max(max,Math.max(root.val,root.val+l+r));
        max=Math.max(max,Math.max(root.val+l,root.val+r));
        return Math.max(root.val,Math.max(root.val+l,root.val+r));
    }
}