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
    TreeNode helper(TreeNode root,int d){
        if(root==null) return null;
        TreeNode left=helper(root.left,d-1);
        TreeNode right=helper(root.right,d-1);
        if(d==1){
            root.left=new TreeNode(v);
            root.right=new TreeNode(v);
            if(left!=null) root.left.left=left;
            if(right!=null) root.right.right=right;
            
        }
        else{
            root.left=left;
            root.right=right;
        }
        return root;
    }
}