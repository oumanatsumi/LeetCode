package Q1001_1500.Q1455;

class Solution {
    public int isPrefixOfWord(String sentence, String searchWord) {
        String[] words = sentence.split(" ");
        for(int i =0;i<words.length;i++)
        {
            if(words[i].length()<searchWord.length())
            {
                continue;
            }
            if(words[i].substring(0,searchWord.length()).equals(searchWord))
            {
                return i+1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int w = s.isPrefixOfWord("hellohello hellohellohello","ell");
        System.out.println(w);
    }

}
