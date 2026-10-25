class Solution {
    public int numIslands(char[][] grid) {
        //edge case, return 0
        if(grid==null||grid.length==0||grid[0].length==0){
            return 0;
        }
        //find row and col
        int row=grid.length;
        int col=grid[0].length;
        //result to return
        int result=0;
        //loop and check if found 1, then increment result and call DFS for that position
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                if(grid[i][j]=='1'){
                    result++;
                    dfs(grid, i, j);
                }
            }
        }
        return result;
    }

        private void dfs(char[][] grid, int row, int col){
            //again same boundary conditions
            if(row<0||row>=grid.length||col<0||col>=grid[0].length||grid[row][col]!='1'){
                return;
            }
            //make the visited node as 0
            grid[row][col]='0';
            //call the DFS for all 4 neighbour
            dfs(grid, row+1, col);
            dfs(grid, row-1, col);
            dfs(grid, row, col+1);
            dfs(grid, row, col-1);
        }
    }
