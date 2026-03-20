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
    int v=0;
    public TreeNode addOneRow(TreeNode root, int val, int depth) {
        if(depth==1){
            TreeNode temp=new TreeNode(val);
            temp.left=root;
            return temp;
        }
        v=val;
        helper(root,depth-1);
        return root;
    }
    void helper(TreeNode root,int d){
        if(root==null) return;
        if(d==1){
            TreeNode left=root.left;
            TreeNode right=root.right;
            root.left=new TreeNode(v);
            root.right=new TreeNode(v);
            root.left.left=left;
            root.right.right=right;
            return;
        }
        helper(root.left,d-1);
        helper(root.right,d-1);
    }
}