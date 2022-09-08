package Q1592;

public class Solution {
    public String reorderSpaces(String text) {
        String[] words = text.trim().split("\\s+");
        int spaceCnt = 0;
        for(char c : text.toCharArray()){
            if(c == ' '){
                spaceCnt ++;
            }
        }
        int avg = words.length > 1 ? spaceCnt / (words.length-1) : 0;
        int leftSpace = words.length > 1 ? spaceCnt % (words.length-1) : spaceCnt;
        String ans = "";
        for(int i = 0;i< words.length-1;i++){
            ans += words[i];
            for (int j = 0; j < avg; j++) {
                ans += " ";
            }
        }
        ans += words[words.length-1];
        for (int j = 0; j < leftSpace; j++) {
            ans += " ";
        }

        return ans;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        String text = "  a   ";
        System.out.println(s.reorderSpaces(text));
    }
}
