class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        //same edge cases
        if(grid==null||grid.length==0||grid[0].length==0){
            return 0;
        }
        //find row and col, and start the 2 loops
        int row=grid.length;
        int col=grid[0].length;
        int result=0;
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                //if found 1(island), calculate area by calling dfs
                if(grid[i][j]==1){
                    int area=dfs(grid, i, j);
                    result=Math.max(result, area);
                }
            }
        }
        return result;
    }
    
    private int dfs(int[][] grid, int row, int col){
        //edge cases-boundary conditions
        if(row<0||row>=grid.length||col<0||col>=grid[0].length||grid[row][col]!=1){
            return 0;
        }
        //make the island as visited zero(0)
        grid[row][col]=0;
        //1 visited, so area becomes 1, and now call the dfs again for all 4 directions
        int area=1;
        area=area+dfs(grid, row+1, col);
        area=area+dfs(grid, row-1, col);
        area=area+dfs(grid, row, col+1);
        area=area+dfs(grid, row, col-1);
        return area;
    }
}
