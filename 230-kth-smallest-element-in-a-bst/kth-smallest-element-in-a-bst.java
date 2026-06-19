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
    int c=0;
    int ans=0;
    void traverse(TreeNode root){
        if(root==null) return;
        traverse(root.left);
        c--;
        if(c==0){
            ans=root.val;
        }
        traverse(root.right);
    }
    public int kthSmallest(TreeNode root, int k) {
        c=k;
        traverse(root);
        return ans;
    }
}