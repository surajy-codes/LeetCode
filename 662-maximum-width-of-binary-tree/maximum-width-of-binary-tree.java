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
    class Pair{
        TreeNode node;
        int idx;
        Pair(TreeNode node,int idx){
            this.node=node;
            this.idx=idx;
        }
    }
    public int widthOfBinaryTree(TreeNode root) {
        if(root==null) return 0;
        int ans=1;
        Queue<Pair> q=new LinkedList<>();
        q.add(new Pair(root,0));
        while(!q.isEmpty()){
            int s=q.size();
            int left=-1,right=-1;
            for(int i=0;i<s;i++){
                Pair curr=q.poll();
                int cidx=curr.idx;
                if(i==0) left=cidx;
                if(i==s-1) right=cidx;

                if(curr.node.left!=null) q.add(new Pair(curr.node.left,cidx*2));
                if(curr.node.right!=null) q.add(new Pair(curr.node.right,cidx*2+1));

            }

            ans=Math.max(ans,right-left+1);
        }
        return ans;
    }
}