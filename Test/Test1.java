package Test;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Test1 {
    TreeSet<Integer> treeSet = new TreeSet<>();
    PriorityQueue<Integer> pq = new PriorityQueue<>();

    public static void main(String[] args) {
        int a = Integer.MAX_VALUE;
        int b = Integer.MAX_VALUE;
        System.out.println((a + b) >>> 1);
   }
}
