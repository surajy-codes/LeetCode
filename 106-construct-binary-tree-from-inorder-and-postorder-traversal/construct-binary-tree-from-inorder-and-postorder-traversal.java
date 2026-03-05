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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        int n=inorder.length;
        return helper(0,n-1,inorder,0,n-1,postorder);
    }
    TreeNode helper(int il,int ih,int[] in,int pl,int ph,int[] post){

        if(il > ih || pl > ph) return null;
        TreeNode root=new TreeNode(post[ph]);
        int i=il;
        while(in[i]!=root.val) i++;
        int lSize=i-il;
        root.left=helper(il,i-1,in,pl,pl+lSize-1,post);
        root.right=helper(i+1,ih,in,pl+lSize,ph-1,post);
        return root;
    }
}