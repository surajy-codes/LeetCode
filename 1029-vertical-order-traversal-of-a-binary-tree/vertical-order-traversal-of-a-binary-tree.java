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
        int val,level;
        Pair(int val,int level){
            this.val=val;
            this.level=level;
        }
    }

    Map<Integer,List<Pair>> map;
    int min=Integer.MAX_VALUE;
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        map=new HashMap<>();
        traverse(root,0,0);
        List<List<Integer>> ans=new ArrayList<>();
        int l=min;
        while(true){
            if(!map.containsKey(l)) break;
            List<Pair> pairs= map.get(l);
            Collections.sort(pairs,(a,b)->{
                if(a.level!=b.level) return a.level-b.level;
                return a.val-b.val;
            });
            List<Integer> temp=new ArrayList<>();
            for(Pair p : pairs) temp.add(p.val);
            ans.add(temp);
            l++;
        }
        return ans;
    }
    void traverse(TreeNode root,int l,int cl){
        if(root==null) return;
        if(!map.containsKey(l)) map.put(l,new ArrayList<>());
        map.get(l).add(new Pair(root.val,cl));
        min=Math.min(min,l);
        traverse(root.left,l-1,cl+1);
        traverse(root.right,l+1,cl+1);
    }
}