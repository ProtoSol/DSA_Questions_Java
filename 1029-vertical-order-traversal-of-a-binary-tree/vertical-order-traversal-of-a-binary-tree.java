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
class Pair{
    int level ;
    int val;
    Pair(int level, int val){
        this.level = level;
        this.val = val;
    }
 }
class Solution {
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        List<List<Integer>> bigList = new ArrayList<>();
        TreeMap<Integer, List<Pair>> map = new TreeMap<>();
        helper(root, 0, map, 0);
        for(int key : map.keySet()){
            List<Pair> l = map.get(key);
            l.sort((a, b)-> a.level - b.level==0?a.val - b.val : a.level - b.level);
            List<Integer> smallList = new ArrayList<>();
           
            for(Pair p : l){
                smallList.add(p.val);
            }
            bigList.add(smallList);
        }
        // for(Map.Entry<Integer, ArrayList<Pair>> m : map.entrySet()){
        //     //bigList.add(m.getValue()); 
        // }
        return bigList;
    }
    void helper(TreeNode node, int hd, TreeMap<Integer, List<Pair>> map, int level){
        // Base case 
        if(node == null){
            return ;
        }
        if(map.get(hd)==null){
          List<Pair> list = new ArrayList<>();
          list.add(new Pair(level , node.val));  
          map.put(hd, list);
        }
        else{
            List<Pair> list = map.get(hd);
            list.add(new Pair(level , node.val));
            map.put(hd, list);
        }
        helper(node.left, hd-1, map, level + 1);
        helper(node.right, hd+1, map, level + 1);
    }
}