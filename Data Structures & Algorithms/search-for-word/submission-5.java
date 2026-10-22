class Solution {
    public boolean exist(char[][] board, String word) {
        //edge case
        if(board==null||board.length==0||board[0].length==0){
            return false;
        }
        //find row and col and call the backtrack method
        int row=board.length;
        int col=board[0].length;
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                if(backTracking(board, word, i, j, 0)){
                    return true;
                }
            }
        }
        return false;
    }

    private boolean backTracking(char[][] board, String word, int row, int col, int index){
        //base condition
        if(index==word.length()){
            return true;
        }

        //boundary conditions
        if(row<0 || row>=board.length || col<0 || col>=board[0].length ||
        board[row][col]!=word.charAt(index)){
            return false;
        }
        //store the value in temp, and then update with '#' to not use this again
        char temp = board[row][col];
        board[row][col]='#';

        //travel all 4 direction, if one becomes true, it is true
        boolean found = backTracking(board, word, row-1, col, index+1)||
        backTracking(board, word, row+1, col, index+1)||
        backTracking(board, word, row, col-1, index+1)||
        backTracking(board, word, row, col+1, index+1);
        //update the value again "UNCHOOSE" step
        board[row][col]=temp;
        return found;



    }
}
