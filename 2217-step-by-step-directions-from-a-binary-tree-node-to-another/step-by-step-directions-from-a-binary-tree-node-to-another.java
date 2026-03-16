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
    public TreeNode lca(TreeNode root, int p, int q) {
        if(root==null || root.val==p || root.val==q) return root;
        TreeNode left=lca(root.left,p,q);
        TreeNode right=lca(root.right,p,q);
        if(left==null) return right;
        else if(right==null) return left;
        else return root;
    }


    String res1,res2;
    boolean helper1(TreeNode root, int f, StringBuilder path){
        if(root == null) return false;
        if(root.val == f){
            res2 = path.toString();
            return true;
        }

        path.append('L');
        if(helper1(root.left, f, path)) return true;
        path.deleteCharAt(path.length() - 1);

        path.append('R');
        if(helper1(root.right, f, path)) return true;
        path.deleteCharAt(path.length() - 1);

        return false;
    }
    
    boolean helper2(TreeNode root, int f, StringBuilder path){
        if(root == null) return false;

        if(root.val == f){
            res1 = path.toString();
            return true;
        }

        path.append('U');
        if(helper2(root.left, f, path)) return true;
        path.deleteCharAt(path.length() - 1);

        path.append('U');
        if(helper2(root.right, f, path)) return true;
        path.deleteCharAt(path.length() - 1);

        return false;
    }

    public String getDirections(TreeNode root, int sv, int dv) {
        TreeNode lca=lca(root,sv,dv);
        helper1(lca,dv,new StringBuilder());
        helper2(lca,sv,new StringBuilder());
        StringBuilder ans=new StringBuilder();
        ans.append(res1);
        ans.append(res2);
        return ans.toString();
    }
}