package LeetCode.Q208;

import java.util.TreeMap;

/**
 * @author Ouma Natsumi
 */
public class Trie {
    private Trie[] children;
    private boolean isEnd;

    public Trie() {
        children = new Trie[26];
        isEnd = false;
    }

    public void insert(String word) {
        Trie node = this;
        for(int i =0; i<word.length();i++)
        {
            char ch = word.charAt(i);
            int index = ch - 'a';
            if(node.children[index]==null)
            {
                node.children[index]=new Trie();
            }
            node = node.children[index];
        }
        node.isEnd = true;
    }

    public boolean search(String word) {
        Trie nodeEnd = searchPrefix(word);
        return nodeEnd != null && nodeEnd.isEnd;
    }

    public boolean startsWith(String prefix) {
        return searchPrefix(prefix)!=null;
    }

    public Trie[] getChildren() {
        return children;
    }

    public boolean isEnd() {
        return isEnd;
    }
    private Trie searchPrefix(String word)
    {
        Trie node = this;
        for(int i =0; i<word.length();i++)
        {
            char ch = word.charAt(i);
            int index = ch - 'a';
            if(this.children[index]==null)
            {
                return null;
            }
            node = this.children[index];
        }
        return node;
    }
}
