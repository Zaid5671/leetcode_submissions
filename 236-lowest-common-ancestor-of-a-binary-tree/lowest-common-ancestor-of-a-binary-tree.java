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
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // i will have to search for all possible paths
        // but if i encounter p or q i will return the node otheriwe if i hit null i will return null
        // due to this if my(i.e curr node) left/right return null that means they didn't got p/q but if not null then they got soemthing
        // if both left and right are not null then that mean i am the LCA
        // other if only one is not null then the LCA should buble one i.e return the exact same node that you got from your kids
        // i.e trust your kids

        if(root == null || root == p || root == q){
            return root;
        }

        TreeNode left = lowestCommonAncestor(root.left,p,q);
        TreeNode right = lowestCommonAncestor(root.right,p,q);

        if(left != null && right != null){
            // YES i am the LCA
            return root;
        }    

        // trust the child which is not null cause it is sending the correct LCA node to you
        if(left != null){
            return left;
        }else{
            return right;
        }
    }
}
