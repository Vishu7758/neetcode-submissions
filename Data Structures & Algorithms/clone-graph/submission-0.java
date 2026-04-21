/*
Definition for a Node.
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
    private Node solve(Node node, Map<Node, Node> mp) {
        if(node == null || mp.containsKey(node)) return mp.get(node);
        Node newNode = new Node(node.val);
        mp.put(node, newNode);
        for(var nbr : node.neighbors) {
            newNode.neighbors.add(solve(nbr, mp));
        }
        return newNode;
    }
    public Node cloneGraph(Node node) {
        Map<Node, Node> mp = new HashMap<>();
        return solve(node, mp);
        // return mp.get(node);
    }
}