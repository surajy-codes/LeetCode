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
    public boolean isCousins(TreeNode root, int x, int y) {
        Queue<TreeNode> q=new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            boolean f1=false;
            boolean f2=false;
            int s=q.size();
            for(int i=0;i<s;i++){
                TreeNode curr=q.poll();
                if(curr.val==x) f1=true;
                if(curr.val==y) f2=true;
                if (curr.left!=null && curr.right!=null) {
                    if ((curr.left.val==x && curr.right.val==y) ||
                        (curr.left.val==y && curr.right.val==x)){
                        return false;
                    }
                }
                if(curr.left!=null) q.add(curr.left);
                if(curr.right!=null) q.add(curr.right);
            }
            if(f1&&f2) return true;//if both are at same level, but we had checked for siblings at previous level,
            if(f1||f2) return false;
        }
        return false;

    }
}