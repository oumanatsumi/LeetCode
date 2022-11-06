package Q1678;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

public class Solution {
    public String interpret(String command) {
        Deque<Character> dq = new LinkedList<>();
        StringBuilder sb = new StringBuilder();
        for(char c:command.toCharArray()){
            if(c == 'G'){
                sb.append(c);
            }else if(c == ')'){
                String temp = "";
                while (!dq.isEmpty()){
                    temp += dq.poll();
                }
                if(temp.equals("la(")) sb.append("al");
                if(temp.equals("(")) sb.append("o");
            }else {
                dq.push(c);
            }
        }
        return sb.toString();
    }
}
