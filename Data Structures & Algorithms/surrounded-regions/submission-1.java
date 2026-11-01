class Solution {
    public void solve(char[][] board) {
        //boundary conditions
        if(board==null || board.length==0||board[0].length==0){
            return;
        }
        int row=board.length;
        int col=board[0].length;

        //top left and top right
        for(int i=0;i<row;i++){
            dfs(board, i, 0);
            dfs(board, i, col-1);
        }

        //top left and bottom left
        for(int j=0;j<col;j++){
            dfs(board, 0, j);
            dfs(board, row-1, j);
        }

        //solution store
        for(int i=0;i<row;i++){
            for(int j=0;j<col;j++){
                if(board[i][j]=='T'){
                    board[i][j]='O';
                }
                else if(board[i][j]=='O'){
                    board[i][j]='X';
                }
            }
        }
    }

        private void dfs(char[][] board, int row, int col){
            //remove scenario - do not needed
            if(row<0||row>=board.length||col<0||col>=board[0].length||board[row][col]!='O'){
                return;
            }
            //assign T, and move all 4 directions
            board[row][col]='T';
            dfs(board, row-1, col);
            dfs(board, row+1, col);
            dfs(board, row, col-1);
            dfs(board, row, col+1);
        }

    }
