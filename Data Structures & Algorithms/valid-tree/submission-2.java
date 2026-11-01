class Solution {
    public boolean validTree(int n, int[][] edges) {

        //boundary condition to remove any chances of cycle
        //IF There is no cycle then it should be equal
        //more edges->cycle, less edges->not connected completely
        if(edges.length!=n-1){
            return false;
        }
        //adjacency list to store neightbors
        List<List<Integer>> list = new ArrayList<>();
        //store empty list for each node
        for(int i=0;i<n;i++){
            list.add(new ArrayList<>());
        }
        //store neibhpurs now
        for(int[] edge:edges){
            list.get(edge[0]).add(edge[1]);
            list.get(edge[1]).add(edge[0]);
        }
        //no need for store int, just boolean as to check
        boolean[] visited = new boolean[n];
        //call the private dfs method
        //instead of calling hasCycle in loop, call dfs with root node
        dfs(0, list, visited);

        //now check for each boolean and if any false, return false, 
        //else return true
        for(boolean v:visited){
            if(!v){
                return false;
            }
        }
        return true;
    }

    private void dfs(int node, List<List<Integer>> list, boolean[] visited){
        //base condition
        if(visited[node]){
            return;
        }
        visited[node]=true;
        //go for all neighbors
        for(int n:list.get(node)){
            dfs(n, list, visited);
        } 
    }
}
