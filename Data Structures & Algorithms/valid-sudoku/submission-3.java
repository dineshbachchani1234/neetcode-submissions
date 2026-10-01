class Solution {
    public boolean isValidSudoku(char[][] board) {
        HashSet<String> set = new HashSet<>();
        //row and column values
        int m=board.length;
        int n=board[0].length;
        //traversal
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                //first check if the cell is not empty, then only check
                if(board[i][j]!='.'){
                    //if anything fails means duplicate, return false
               if(!(set.add(board[i][j] +"at row" +i))||
                (!set.add(board[i][j] +"at column" +j))||
                (!set.add(board[i][j] +"at board" +i/3 +"and" +j/3))){
                    return false;
                }
            }
            }
        }
        return true;
    }
}
