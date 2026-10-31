class Solution {
    public int orangesRotting(int[][] grid) {
        //boundary conditions
        if(grid==null || grid.length==0 || grid[0].length==0){
            return 0;
        }
        int row=grid.length;
        int col=grid[0].length;
        int freshFruits=0;
        Queue<int[]> queue = new LinkedList<>();
        //scan the entire grid, and take operation for freshFrutis as well as rotten fruits
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                if(grid[i][j]==1){
                    freshFruits++;
                }
                else if(grid[i][j]==2){
                    queue.offer(new int[]{i,j});
                }
            }
        }
        //simple if no freshFruits, no need for anything, simply return
        if(freshFruits==0){
            return 0;
        }
        return bfs(grid, queue, freshFruits);
    }

    private int bfs(int[][] grid, Queue<int[]> queue, int freshFruits){
        int minutes=0;
        //for all directions
        int[][] directions = {{-1,0}, {1,0}, {0,-1}, {0,1}};

        //condition to come out, if no freshFruits or no loop for rotten fruits remaining
        while(!queue.isEmpty() && freshFruits>0){
            int size=queue.size();
            //travel for all rotten fruits in queue
            for(int i=0;i<size;i++){
                int[] element = queue.poll();
                int row=element[0];
                int col=element[1];
                //keep finding all 4 directions of that rotten fruit
                for(int[] dir:directions){
                    int newRow=row+dir[0];
                    int newCol=col+dir[1];
                    //condition check if found freshfruits, make them rotten and add in queue,
                    //also decrement freshfruits
                    if(newRow>=0 && newRow<grid.length && newCol>=0 && newCol<grid[0].length 
                            && grid[newRow][newCol] == 1){
                        grid[newRow][newCol]=2;
                        freshFruits--;
                        queue.offer(new int[]{newRow, newCol});
                    }
                }
            }
            minutes++;
        }
        return freshFruits==0?minutes:-1;
    }
}
