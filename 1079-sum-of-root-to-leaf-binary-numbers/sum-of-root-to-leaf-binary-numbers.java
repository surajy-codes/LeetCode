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
    public int sumRootToLeaf(TreeNode root) {
        List<String> list=new ArrayList<>();
        paths(root,new StringBuilder(),list);
        int ans=0;
        for(String s : list){
            ans+=Integer.parseInt(s,2);
        }
        return ans;
    }
    void paths(TreeNode root,StringBuilder curr,List<String> list){
        if(root==null) return;
        if(root.left==null && root.right==null){
            curr.append(root.val);
            list.add(curr.toString());
            curr.deleteCharAt(curr.length()-1);
            return ;
        }

        curr.append(root.val);
        paths(root.left,curr,list);
        paths(root.right,curr,list);
        curr.deleteCharAt(curr.length()-1);
    }
}