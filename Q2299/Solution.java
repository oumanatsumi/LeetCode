package Q2299;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

class Solution {
    public boolean strongPasswordCheckerII(String password) {
        Boolean[] conditions = {false,false,false,false,false};
        String temp = "!@#$%^&*()-+";
        if(password.length()>=8) conditions[0] = true;
        for (int i = 0; i < password.length(); i++) {
            char c = password.charAt(i);
            if(c >= 'a' && c <= 'z') conditions[1] = true;
            if(c >= 'A' && c <= 'Z') conditions[2] = true;
            if(c >= '0' && c <= '9') conditions[3] = true;
            if(temp.contains(""+c)) conditions[4] = true;
            if(i > 0 && c == password.charAt(i-1)) return false;
        }
        return Arrays.stream(conditions).allMatch(con -> con);
    }
}
