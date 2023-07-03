package SPOffer.SPOffer20;

import java.util.HashMap;
import java.util.Map;

class Solution {
    // 有限状态自动机
    public boolean isNumber(String s) {
        //' ' = 空格，'s' = 符号, 'e' = 幂, 'd' = 数字, 'p' = 小数点
        Map[] stats = {
                new HashMap<Character, Integer>() {{put(' ',0); put('s',1); put('d',2); put('p',4);}},
                new HashMap<Character, Integer>() {{put('d',2); put('p',4);}},
                new HashMap<Character, Integer>() {{put('d',2); put('p',3); put('e',5); put(' ',8);}},
                new HashMap<Character, Integer>() {{put('d',3); put('e',5); put(' ',8);}},
                new HashMap<Character, Integer>() {{put('d',3); }},
                new HashMap<Character, Integer>() {{put('s',6); put('d',7);}},
                new HashMap<Character, Integer>() {{put('d',7);}},
                new HashMap<Character, Integer>() {{put('d',7); put(' ',8);}},
                new HashMap<Character, Integer>() {{put(' ',8);}}
        };
        int pointer = 0;
        char t;
        for(char c: s.toCharArray()){
            if(c == ' ') t = c;
            else if(c == '.') t = 'p';
            else if(c == '+' || c == '-') t = 's';
            else if(c >= '0' && c <= '9') t = 'd';
            else if(c == 'e' || c == 'E') t = 'e';
            else t = '?';
            if(!stats[pointer].containsKey(t)) return false;
            pointer = (int) stats[pointer].get(t);
        }
        return pointer == 2 || pointer == 3 || pointer == 7 || pointer == 8;
    }
}
