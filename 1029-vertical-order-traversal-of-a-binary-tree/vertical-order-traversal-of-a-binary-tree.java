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
        int x;//vertical dist
        int y;// level

        public Tuple(TreeNode node,int x, int y){
            this.node = node;
            this.x = x;
            this.y = y;
        }
    }
    
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        //your code goes here
        List<List<Integer>> result = new ArrayList<>();

        if (root == null) {
            return result;
        }
        TreeMap<Integer, TreeMap<Integer, PriorityQueue<Integer>>> map = new TreeMap<>();

        Queue<Tuple> q = new LinkedList<>();

        q.offer(new Tuple(root,0,0));

        while(!q.isEmpty()){
            Tuple tuple = q.poll();
            TreeNode node = tuple.node;
            int x = tuple.x;
            int y = tuple.y;

            map.putIfAbsent(x,new TreeMap<>());
            map.get(x).putIfAbsent(y,new PriorityQueue<>());
            
            map.get(x).get(y).offer(node.val);

            if(node.left != null){
                q.offer(new Tuple(node.left,x-1,y+1));
            }
            if(node.right != null){
                q.offer(new Tuple(node.right,x+1,y+1));
            }

        }

        for(TreeMap<Integer,PriorityQueue<Integer>> yMap : map.values()){
            List<Integer> col = new ArrayList<>();
            for(PriorityQueue<Integer> nodes : yMap.values()){
                while(!nodes.isEmpty()){
                    col.add(nodes.poll());
                }
            }
            result.add(col);
        }
        return result;
    }   
}
