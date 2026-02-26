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
    public int rob(TreeNode root) {
        HashMap<TreeNode,Integer> dp=new HashMap<>();
        int ans=sum(root,dp);
        return ans;
    }
    int sum(TreeNode root,HashMap<TreeNode,Integer> dp){
        if(root==null) return 0;
        if(dp.containsKey(root)) return dp.get(root);

        int ans1=root.val;
        if(root.left!=null){
            ans1+=sum(root.left.left,dp) + sum(root.left.right,dp);
        }if(root.right!=null) ans1+=sum(root.right.left,dp)+sum(root.right.right,dp);

        int ans2=sum(root.left,dp)+sum(root.right,dp);
        dp.put(root,Math.max(ans1,ans2));
        return Math.max(ans1,ans2);
    }
}