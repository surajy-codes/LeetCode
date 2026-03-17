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

    Map<Integer,Integer> map;
    public int[] findFrequentTreeSum(TreeNode root) {
        map=new HashMap<>();
        helper(root);
        List<Integer> ans=new ArrayList<>();
        int maxf=0;
        for(int k : map.keySet()){
            if(map.get(k)>maxf){
                ans=new ArrayList<>();
                maxf=map.get(k);
            }
            if(map.get(k)==maxf) ans.add(k);
        }
        int[] a=new int[ans.size()];
        for(int i=0;i<a.length;i++){
            a[i]=ans.get(i);
        }
        return a;
    }
    int helper(TreeNode root){
        if(root==null) return 0;
        int l=helper(root.left);
        int r=helper(root.right);
        int sum=l+r+root.val;
        map.put(sum,map.getOrDefault(sum,0)+1);
        return sum;
    }
}