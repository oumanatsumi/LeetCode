package LeetCode.Q211;

import java.util.ArrayList;
import java.util.List;

import LeetCode.Q208.Trie;
/**
 * @author Ouma Natsumi
 */

//超时了

//public class WordDictionary {
//
//    private List<String> dic;
//    public WordDictionary() {
//        dic = new ArrayList<String>();
//    }
//
//    public void addWord(String word) {
//        if(!search(word)) {
//            dic.add(word);
//        }
//    }
//
//    public boolean search(String word) {
//        boolean res = false;
//        for (String dicWord:dic) {
//             if (compareWords(dicWord,word))
//             {
//                 res = true;
//             }
//        }
//        return res;
//    }
//
//    private boolean compareWords(String word1,String word2)
//    {
//        boolean res = true;
//        if(word1.length()!=word2.length())
//        {
//            return false;
//        }
//        int index = 0;
//        while(index < word1.length())
//        {
//            if(word1.charAt(index) == word2.charAt(index) || '.' == word1.charAt(index) ||'.' == word2.charAt(index))
//            {
//                index++;
//            }
//            else
//            {
//                res = false;
//                break;
//            }
//        }
//        return res;
//    }
//
//
//    public static void main(String[] args)
//    {
//        WordDictionary wd = new WordDictionary();
//        wd.addWord("a");
//        wd.addWord("a");
//        System.out.println(wd.search("."));
//        System.out.println(wd.search("a"));
//        System.out.println(wd.search("aa"));
//        System.out.println(wd.search(".a"));
//        System.out.println(wd.search("a."));
//    }
//
//}

class WordDictionary {
    private Trie root;
    public WordDictionary() {
        root = new Trie();
    }

    public void addWord(String word) {
        root.insert(word);
    }

    public boolean search(String word) {
        return dfs(word,0,root);
    }

    private boolean dfs(String word,int index,Trie node)
    {
        if(node.isEnd() && index == word.length())
        {
            return true;
        }
        if(index >= word.length())
        {
            return false;
        }
        char ch = word.charAt(index);
        if(ch>='a' && ch<='z')
        {
            int ind = ch-'a';
            if(node.getChildren()[ind]==null)
            {
                return false;
            }
            else
            {
                return dfs(word,index+1,node.getChildren()[ind]);
            }
        }
        else if(ch=='.')
        {
            for(int i=0;i<26;i++)
            {
                if(node.getChildren()[i]!=null)
                {
                    if(dfs(word,index+1,node.getChildren()[i]))
                    {
                        return true;
                    }
                }
            }
        }
        return false;
    }



    public static void main(String[] args)
    {
        WordDictionary w =new WordDictionary();
        w.addWord("at");
        w.addWord("and");
        w.addWord("an");
        w.addWord("add");
        System.out.println(w.search(".at"));
        w.addWord("bat");
        System.out.println(w.search(".at"));

    }

}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */