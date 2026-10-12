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
    public boolean findTarget(TreeNode root, int k) {
        HashSet<Integer> set = new HashSet<>();
        Deque<TreeNode> st = new ArrayDeque<>();
        st.push(root);
        while(!st.isEmpty()){
            TreeNode curr = st.pop();
            if(set.contains(k-curr.val))return true;
            set.add(curr.val);
            if(curr.left != null){
                st.push(curr.left);
            }
            if(curr.right != null){
                st.push(curr.right);
            }
        } 
        return false;
    }
}