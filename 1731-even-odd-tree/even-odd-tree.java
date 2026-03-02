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
    public boolean isEvenOddTree(TreeNode root) {
        int l=0;
        Queue<TreeNode> q=new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){

            int s=q.size();
            int prev=-1;
            if(l%2==0) prev=0;
            else prev=Integer.MAX_VALUE;
            for(int i=0;i<s;i++){
                TreeNode curr=q.poll();
                if(l%2==0){
                    if(curr.val%2==0) return false;
                    if(prev>=curr.val) return false;
                }else{
                    if(curr.val%2!=0) return false;
                    if(prev<=curr.val) return false;
                }
                prev=curr.val;
                if(curr.left!=null) q.add(curr.left);
                if(curr.right!=null) q.add(curr.right);
            }
            l++;
        }
        return true;
    }
}