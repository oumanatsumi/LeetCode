package Q419;

class Solution {
    public int countBattleships(char[][] board) {
        int res=0;
        for(int i=0;i<board.length;i++)
        {
            for(int j=0;j<board[i].length;j++)
            {
                if(board[i][j]=='X')
                {
                    if(i==0 && j==0)
                    {
                        res++;
                    }
                    else if(i==0)
                    {
                        if(board[i][j-1]=='.')
                        {
                            res++;
                        }
                    }
                    else if(j==0)
                    {
                        if(board[i-1][j]=='.')
                        {
                            res++;
                        }
                    }
                    else
                    {
                        if(board[i][j-1]=='.' && board[i-1][j]=='.')
                        {
                            res++;
                        }
                    }
                }
            }
        }
        return res;
    }
}
