package Q520;

class Solution {
    public boolean detectCapitalUse(String word) {
        if(word.toUpperCase().equals(word))
        {
            return true;
        }
        if(word.toLowerCase().equals(word))
        {
            return true;
        }
        if(word.charAt(0)>='A' && word.charAt(0) <='Z' && word.substring(1).toLowerCase().equals(word.substring(1)))
        {
            return true;
        }
        return false;
    }

    public static void main(String[] args)
    {
        Solution s = new Solution();
        System.out.println(s.detectCapitalUse("QeeqqQe"));
    }
}
