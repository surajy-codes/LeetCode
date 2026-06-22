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
    int ans=0;
    public int sumNumbers(TreeNode root) {
        helper(root,0);
        return ans;
    }
    int helper(TreeNode root,int curr){
        if(root==null) return 0;
        if(root.left==null && root.right==null){
            curr*=10;
            curr+=root.val;
            ans+=curr;
            return curr;
        }

        curr*=10;
        curr+=root.val;
        helper(root.left,curr);
        helper(root.right,curr);
        return  curr;
    }
}