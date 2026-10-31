class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        List<List<Integer>> result = new ArrayList<>();
        //boundary conditions
        if(heights==null || heights.length==0 || heights[0].length==0){
            return result;
        }
        int row=heights.length;
        int col=heights[0].length;
        //two boolean to check for both oceans if visited or not
        boolean[][] pacVisited = new boolean[row][col];
        boolean[][] altVisited = new boolean[row][col];

        //top left and top right start and travel below
        for(int i=0;i<row;i++){
            dfs(heights, i, 0, pacVisited, heights[i][0]);
            dfs(heights, i, col-1, altVisited, heights[i][col-1]);
        }
        //top left and bottom left start, and travel to right
        for(int j=0;j<col;j++){
            dfs(heights, 0, j, pacVisited, heights[0][j]);
            dfs(heights, row-1, j, altVisited, heights[row-1][j]);
        }

        //whatever is visited means allowed, so add in result array
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                if(pacVisited[i][j] && altVisited[i][j]){
                    result.add(Arrays.asList(i,j));
                }
            }
        }
        return result;
    }

    private void dfs(int[][] heights, int row, int col, boolean[][] visited, int prevHeight){
        //boundary conditions
        if(row<0||row>=heights.length||col<0||col>=heights[0].length||visited[row][col]||
        heights[row][col]<prevHeight){
            return;
        }
        visited[row][col]=true;

        //travel in all 4 directions
        dfs(heights, row-1, col, visited, heights[row][col]);
        dfs(heights, row+1, col, visited, heights[row][col]);
        dfs(heights, row, col-1, visited, heights[row][col]);
        dfs(heights, row, col+1, visited, heights[row][col]);
    }

}
