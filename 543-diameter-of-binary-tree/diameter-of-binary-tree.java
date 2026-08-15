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
    private int maxDia = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        // reset for multiple test cases
        maxDia = 0;
        height(root);
        return maxDia;
    }
    public int height(TreeNode root){
        if(root == null)return 0;
        int lH = height(root.left);
        int rH = height(root.right);

        maxDia = Math.max(maxDia,lH+rH);

        return 1+Math.max(lH,rH);
    }
}