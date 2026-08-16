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
    private int maxSum;
    public int maxPathSum(TreeNode root) {
        //your code goes here 
        maxSum = Integer.MIN_VALUE;
        pathSum(root);
        return maxSum;
    }
    public int pathSum(TreeNode root){
        if(root == null)return 0;

        int lS = pathSum(root.left);
        int rS = pathSum(root.right);
        int val = root.val;

        if(lS<0)lS = 0;
        if(rS<0)rS = 0;

        maxSum = Math.max(maxSum,(lS+rS+val));
        return val+Math.max(lS,rS);
    }
}