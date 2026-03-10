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
    public int findSecondMinimumValue(TreeNode root) {
        PriorityQueue<Integer> pq=new PriorityQueue<>();
        Set<Integer>set=new HashSet<>();
        dfs(root,set,pq);
        pq.remove();
        return pq.size()==0?-1:pq.peek();
    }
    void dfs(TreeNode root,Set<Integer> set,PriorityQueue<Integer>pq){
        if(root==null) return;
        if(!set.contains(root.val)){
            set.add(root.val);
            pq.add(root.val);
        }
        dfs(root.left,set,pq);
        dfs(root.right,set,pq);
    }
}