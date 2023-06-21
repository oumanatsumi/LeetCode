package Q1001_1500.Q1487;

import java.util.HashMap;
import java.util.Map;

class Solution {

    public String[] getFolderNames(String[] names) {
        Map<String, Integer> d = new HashMap<>();
        for (int i = 0; i < names.length; ++i) {
            if (d.containsKey(names[i])) {
                int k = d.get(names[i]);
                while (d.containsKey(names[i] + "(" + k + ")")) {
                    ++k;
                }
                d.put(names[i], k);
                names[i] += "(" + k + ")";
            }
            d.put(names[i], 1);
        }
        return names;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        s.getFolderNames(new String[]{"gta","gta(1)","gta","avalon"});
    }
}
