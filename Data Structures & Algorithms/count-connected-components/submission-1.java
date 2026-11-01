class Solution {
    public int countComponents(int n, int[][] edges) {
        List<List<Integer>> list = new ArrayList<>();
        //empty list
        for(int i=0;i<n;i++){
            list.add(new ArrayList<>());
        }
        //store undirected edges, so both direction dependency
        for(int[] edge:edges){
            list.get(edge[0]).add(edge[1]);
            list.get(edge[1]).add(edge[0]);
        }
        //to track for each node if visited or not
        boolean[] visited = new boolean[n];
        //output to return
        int count=0;
        //check each node if visited or not, if not, increment count and run dfs
        for(int i=0;i<n;i++){
            if(!visited[i]){
                count++;
                dfs(i, list, visited);
            }
        }
        return count;
    }
    private void dfs(int node, List<List<Integer>> list, boolean[] visited){
        //if already visited, simply return
        if(visited[node]){
            return;
        }
        visited[node]=true;
        //dfs for all it's connected nodes
        for(int n:list.get(node)){
            dfs(n, list, visited);
        }
    }
}
