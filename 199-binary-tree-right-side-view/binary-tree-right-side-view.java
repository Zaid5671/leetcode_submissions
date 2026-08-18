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
    static class Tuple{
        TreeNode node;
         int y;
         public Tuple(TreeNode node,int y){
            this.node = node;
            this.y = y;
         }
    }
    public List<Integer> rightSideView(TreeNode root) {
        if(root == null)return new ArrayList<>();
        //your code goes here
        TreeMap<Integer,Integer> map = new TreeMap<>();
        
        Queue<Tuple> q = new LinkedList<>();

        q.offer(new Tuple(root,0));

        while(!q.isEmpty()){
            Tuple tuple = q.poll();
            TreeNode node = tuple.node;
            int y = tuple.y;

            map.put(y,node.val);

            if(node.left != null){
                q.offer(new Tuple(node.left,y+1));
            } 
            if(node.right != null){
                q.offer(new Tuple(node.right,y+1));
            }
        }

        return new ArrayList<>(map.values());
    }
}
 