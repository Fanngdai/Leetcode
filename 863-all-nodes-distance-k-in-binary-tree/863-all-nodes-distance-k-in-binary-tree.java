/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public List<Integer> distanceK(TreeNode root, TreeNode target, int dist) {
        List<Integer> rtn = new ArrayList<>();
        if(dist==0) {
            rtn.add(target.val);
            return rtn;
        }
        
        HashMap<Integer, List<Integer>> graph = new HashMap<>();        
        distanceKHelper(root, graph, target.val, dist, Integer.MIN_VALUE);
        
        if(graph.size() < dist) {
            return rtn;
        }
        
        Queue<Integer> queue = new LinkedList<>();
        Set<Integer> set = new HashSet<>();
        
        addToQueue(graph.get(target.val), queue, set, target.val);
        set.add(target.val);
        
        for(int i=0; i<dist; i++) {
            int qSize = queue.size();
            for(int j=0; j<qSize; j++) {
                if(i == dist - 1) {
                    rtn.add(queue.poll());
                } else {
                    int qVal = queue.poll();
                    addToQueue(graph.get(qVal), queue, set, qVal);   
                }
            }
        }
        
        return rtn;
    }
    
    private void distanceKHelper(TreeNode root, HashMap<Integer, List<Integer>> hashMap,
                                 int target, int dist, int distCounter) {
        if(root == null) {
            return;
        }        
        
        if(root.val == target) {
            distCounter = 0;
        }
        
        if(root.left != null) {
            addToHashMap(hashMap, root.val, root.left.val);
            addToHashMap(hashMap, root.left.val, root.val);
            if(dist != distCounter) {
                distanceKHelper(root.left, hashMap, target, dist, distCounter++);
            }
        }
        
        if(root.right != null) {
            addToHashMap(hashMap, root.val, root.right.val);
            addToHashMap(hashMap, root.right.val, root.val);
            if(dist != distCounter) {
                distanceKHelper(root.right, hashMap, target, dist, distCounter++);
            }
        }
    }
    
    private void addToHashMap(HashMap<Integer, List<Integer>> hashMap, int key, int val) {
        if(hashMap.containsKey(key)) {
            hashMap.get(key).add(val);
        } else {
            List<Integer> lst = new ArrayList<>();
            lst.add(val);
            hashMap.put(key, lst);
        }
    }
    
    private void addToQueue(List<Integer> lst, Queue<Integer> queue, Set<Integer> set, int val) {
        for(Integer i: lst) {
            if(!set.contains(i)) {
                queue.add(i);
            }
        }
        set.add(val);
    }
}

/*
Cases:
    if the target is 0, just return the actual val -> base case
    
    root = [3,5,1,6,2,0,8,null,null,7,4], target = 2, k = 2
    in this case, we want [6,3] -> it's easy to get 3, but how to get 6?
    
Logic:
    Convert to a graph using hashmap
    bidirectional graph -> if node a is next to node b, then node b is next to node a
    have a set to prevent cycles.
        if node is visited, do not visit again
    Do a BFS on the hashmap / graph
    
    
    
[3,5,1,6,2,0,8,null,null,7,4]
2
2

[3,5,1,6,2,0,8,null,null,7,4]
1
3
*/