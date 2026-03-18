class Solution {
    TreeNode prev=null,head=null;
    public TreeNode increasingBST(TreeNode root) {
        if(root==null) return root;
        increasingBST(root.left);
        if(prev!=null){
            root.left=null;
            prev.right=root;
        }
        if(head==null) head=root;//for the head, it would be the left most of the tree
        prev=root;
        increasingBST(root.right);
        return head;
    }
}