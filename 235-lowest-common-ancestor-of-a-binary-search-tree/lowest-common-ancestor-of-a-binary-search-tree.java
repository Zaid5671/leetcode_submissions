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
        // since it is a BST the nodes will split at one point and that point is the LCA

        while(true){
            int currVal = root.val;
            if(p.val == currVal)return root;
            if(q.val == currVal)return root;
            if(p.val<currVal && q.val<currVal){
                root = root.left;
            }
            else if(p.val>currVal && q.val>currVal){
                root = root.right;
            }
            else{
                break;
            }
        }

        return root;
    }
}
