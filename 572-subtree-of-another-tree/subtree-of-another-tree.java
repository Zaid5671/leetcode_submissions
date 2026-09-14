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
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if(root == null && subRoot == null)return true;
        if(root == null || subRoot == null)return false;
        Queue<TreeNode> q = new LinkedList<>();

        q.offer(root);

        while(!q.isEmpty()){
            TreeNode curr = q.poll();
            if(isSame(curr,subRoot)){
                return true;
            }

            if(curr.left != null){
                q.offer(curr.left);
            }
            if(curr.right != null){
                q.offer(curr.right);
            }
        }

        return false;
    }
    public boolean isSame(TreeNode p, TreeNode q){
        if(p == null && q == null)return true;
        if(p == null || q == null)return false;

        if(p.val != q.val)return false;

        return isSame(p.left,q.left) && isSame(p.right,q.right); 
    }
}
