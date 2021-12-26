/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    public Node cloneGraph(Node node) {
        return node == null ? null : cloneGraphHelper(new Node(), node, new HashMap<>());
    }
    
    public Node cloneGraphHelper(Node rtn, Node node, HashMap<Integer, Node> hash) {
        hash.put(node.val, rtn);
        rtn.val = node.val;
        rtn.neighbors = new ArrayList<>();
        for(Node n: node.neighbors) {
            if(hash.containsKey(n.val)) {
                rtn.neighbors.add(hash.get(n.val));
            } else {
                rtn.neighbors.add(cloneGraphHelper(new Node(), n, hash));   
            }
        }
        return rtn;
    }
}