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
    public int diameterOfBinaryTree(TreeNode root) {
        //your code goes here
        if(root == null)return 0;
        int[] maxDia = new int[1];
        height(root,maxDia);
        return maxDia[0];
    }
    public int height(TreeNode root,int[] maxDia){
        if(root == null)return 0;
        int lH = height(root.left,maxDia);
        int rH = height(root.right,maxDia);

        maxDia[0] = Math.max(maxDia[0],lH+rH);

        return 1+Math.max(lH,rH);
    }
}