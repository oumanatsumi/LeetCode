package Q2001_2500.Q2357;

import java.util.TreeMap;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

class Solution {
    public int minimumOperations(int[] nums) {
       return IntStream.of(nums).filter(e -> e!=0).boxed()
                .collect(Collectors.groupingBy(e->e, TreeMap::new, Collectors.counting()))
                .size();
    }
}
