package Test;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

class Test1 {


    public static void main(String[] args) {
        TreeMap<Integer,Integer> treeMap = new TreeMap<>();
        treeMap.put(2,1);
        treeMap.put(1,1);
        treeMap.put(3,3);
        treeMap.put(0,2);
        System.out.println(treeMap.firstEntry().getKey());
        System.out.println(treeMap.lastEntry().getKey());

    }
}
