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

        Stack<TreeNode> st = new Stack<>();

        st.push(root);

        int maxDia = 0;

        while(!st.isEmpty()){
            TreeNode curr = st.pop();
            if(curr.left != null){
                st.push(curr.left);
            }
            if(curr.right != null){
                st.push(curr.right);
            }

            int lH = height(curr.left);
            int rH = height(curr.right);

            int diameter = lH+rH;

            maxDia = Math.max(maxDia,diameter);

        }
        return maxDia;
    }
    public int height(TreeNode root){
        if(root == null)return 0;
        return 1+Math.max(height(root.left),height(root.right));
    }
}