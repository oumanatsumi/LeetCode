package SPOffer12;

class Solution {
    int m,n;
    public boolean exist(char[][] board, String word) {
        boolean[][] visited;
        m = board.length;
        n = board[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if(board[i][j] == word.charAt(0)){
                    visited = new boolean[m][n];
                    visited[i][j] = true;
                    if(dfs(board,word,visited,0,i,j)) return true;
                }
            }
        }
        return false;
    }

    private boolean dfs(char[][] board, String word, boolean[][] visited, int index, int i, int j){
        // end condition
        if(index == word.length()-1){
            return true;
        }
        boolean left = false,right= false,up= false,down= false;
        // up
        if(i > 0 && !visited[i-1][j] && board[i-1][j] == word.charAt(index+1)){
            visited[i-1][j] = true;
            up = dfs(board,word,visited,index+1,i-1,j);
            if(!up) visited[i-1][j] = false;
        }
        // down
        if(i < m-1 && !visited[i+1][j] && board[i+1][j] == word.charAt(index+1)){
            visited[i+1][j] = true;
            down = dfs(board,word,visited,index+1,i+1,j);
            if(!down) visited[i+1][j] = false;
        }
        //left
        if(j > 0 && !visited[i][j-1] && board[i][j-1] == word.charAt(index+1)){
            visited[i][j-1] = true;
            left = dfs(board,word,visited,index+1,i,j-1);
            if(!left) visited[i][j-1] = false;
        }
        // right
        if(j < n-1 && !visited[i][j+1] && board[i][j+1] == word.charAt(index+1)){
            visited[i][j+1] = true;
            right = dfs(board,word,visited,index+1,i,j+1);
            if(!right) visited[i][j+1] = false;
        }
        return left || right || up || down;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        boolean res = s.exist(new char[][]{{'A','B','C','E'},{'S','F','E','S'},{'A','D','E','E'}},"ABCESEEEFS");
        System.out.println(res);
    }
}
