package Q1_500.Q500;


import java.util.ArrayList;
import java.util.List;

class Solution {
    public String[] findWords(String[] words) {
        List<String> res = new ArrayList<>();
        String[] keyBoard = new String[3];
        keyBoard[0] ="qwertyuiop";
        keyBoard[1] ="asdfghjkl";
        keyBoard[2] ="zxcvbnm";
        for (String word:words) {
            String tempWord = word;
            word = word.toLowerCase();
            String firstChar = word.substring(0,1);
            int lineIndex = 0;
            if(keyBoard[1].contains(firstChar)) {
                lineIndex =1;
            }
            else if(keyBoard[2].contains(firstChar)) {
                lineIndex = 2;
            }
            int index = 1;
            boolean flag = true;
            while (index < word.length())
            {
                if(!keyBoard[lineIndex].contains(word.substring(index,index+1)))
                {
                    flag = false;
                    break;
                }
                index ++;
            }
            if(flag)
            {
                res.add(tempWord);
            }
        }
        return res.toArray(new String[res.size()]);

    }


    public static void main(String[] args)
    {
        Solution s = new Solution();
        String[] words = {"Hello","Alaska","Dad","Peace"};
        String[] res =  s.findWords(words);
        for(String str :res)
        {
            System.out.println(str);
        }

    }
}
