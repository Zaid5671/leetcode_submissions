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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        //your code goes here
        List<List<Integer>> ans = new ArrayList<>();
        if(root == null)return ans;
        Stack<TreeNode> st1 = new Stack<>();
        Stack<TreeNode> st2 = new Stack<>();
        st1.push(root);

        while(!st1.isEmpty()){
            int n1 = st1.size();
            List<Integer> list1 = new ArrayList<>();
            for(int i = 0;i<n1;i++){
                TreeNode curr = st1.pop();
                list1.add(curr.val);
                if(curr.left != null){
                    st2.push(curr.left);
                }
                if(curr.right != null){
                    st2.push(curr.right);
                }
            }
            ans.add(list1);
            int n2 = st2.size();
            if(n2==0)break;
            List<Integer> list2 = new ArrayList<>();
            for(int j = 0;j<n2;j++){
                TreeNode curr = st2.pop();
                list2.add(curr.val);
                if(curr.right != null){
                    st1.push(curr.right);
                }
                if(curr.left != null){
                    st1.push(curr.left);
                }
            }
            ans.add(list2);
        }
        return ans;
    }
}