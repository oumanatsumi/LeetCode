package Q1704;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public boolean halvesAreAlike(String s) {
        int n = s.length();
        Character[] chars = {'a','e','i','o','u','A','E','I','O','U'};
        List<Character> list = Arrays.asList(chars);
        int cnt = 0;
        for (int i = 0; i < n/2; i++) {
            if(list.contains(s.charAt(i))){
                cnt++;
            }
        }
        for (int i = n/2; i < n; i++) {
            if(list.contains(s.charAt(i))){
                cnt--;
            }
        }
        return cnt==0 ;
    }
}
