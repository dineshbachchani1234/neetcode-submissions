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
    public Node cloneGraph(Node node) {
        //edge case
        if(node==null){
            return null;
        }
        //map to check if visited or not
        Map<Node, Node> visited = new HashMap<>();
        return dfs(node, visited);
    }

    private Node dfs(Node node, Map<Node, Node> visited){
        //if node is already visited, it have clonedNode, just return
        if(visited.containsKey(node)){
            return visited.get(node);
        }
        //make a clone and put it in map
        Node clonedNode = new Node(node.val);

        visited.put(node, clonedNode);
        //find neighbors of original node
        for(Node neighbor: node.neighbors){
            //keep making the clonedNeighbor and adding in the list(neighbors)
            Node clonedNeighbor = dfs(neighbor, visited); 
            clonedNode.neighbors.add(clonedNeighbor);
        }
        return clonedNode;
    }


}