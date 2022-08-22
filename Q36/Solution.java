package Q36;

public class Solution {
    public boolean isValidSudoku(char[][] board) {
        int len = 9;

        for(int i=0;i<len;i++)
        {
            boolean[] col = new boolean[len+1];
            boolean[] row = new boolean[len+1];
            for(int j=0;j<len;j++)
            {
                if(board[i][j]!='.')
                {
                    if(!col[(int)board[i][j]-(int)'0'])
                    {
                        col[(int)board[i][j]-(int)'0']  = true;
                    }
                    else
                    {
                        return false;
                    }
                }
                if(board[j][i]!='.')
                {
                    if(!row[(int)board[j][i]-(int)'0'])
                    {
                        row[(int)board[j][i]-(int)'0']  = true;
                    }
                    else
                    {
                        return false;
                    }
                }
            }
        }

        int size =3;

        for(int i=0;i<size;i++)
        {
            for(int j=0;j<size;j++)
            {
                boolean[] cube = new boolean[10];
                for(int r=i*3;r<(i+1)*3;r++)
                {
                    for(int l=j*3;l<(j+1)*3;l++)
                    {
                        if(board[r][l]!='.')
                        {
                            if(!cube[(int)board[r][l]-(int)'0'])
                            {
                                cube[(int)board[r][l]-(int)'0']  = true;
                            }
                            else
                            {
                                return false;
                            }
                        }
                    }
                }
            }
        }
        return true;
    }

    public static void main(String[] args)
    {
        Solution s = new Solution();
        char [][] board =
                       {{'.','.','.','.','5','.','.','1','.'},
                        {'.','4','.','3','.','.','.','.','.'},
                        {'.','.','.','.','.','9','.','.','1'},
                        {'8','.','.','.','.','.','.','2','.'},
                        {'.','.','2','.','7','.','.','.','.'},
                        {'.','1','5','.','.','.','.','.','.'},
                        {'.','.','.','.','.','2','.','.','.'},
                        {'.','2','.','9','.','.','.','.','.'},
                        {'.','.','4','.','.','.','.','.','.'}};



        System.out.println(s.isValidSudoku(board));
    }

}
