package Test;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Test1 {
    TreeSet<Integer> treeSet = new TreeSet<>();
    PriorityQueue<Integer> pq = new PriorityQueue<>();

    public static void main(String[] args) {
        Integer i1 = new Integer(1);
        Integer i2 = new Integer(223231);
        Integer i3 = 223231;
        String s1 = "22";
        StringBuilder sb1 = new StringBuilder("sd");
        StringBuilder sb2 = new StringBuilder("sd");
        List<Integer> l1 = new ArrayList<>();
        List<Integer> l2 = new ArrayList<>();
        Double d1 = 0.05;
        Double d2 = 0.05;
        System.out.println(d1.hashCode());
        System.out.println(d2.hashCode());

        Hashtable<Integer,Integer> hashtable = new Hashtable<>();
   }
}
