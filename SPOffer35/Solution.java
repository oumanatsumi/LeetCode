package SPOffer35;

import java.util.HashMap;
import java.util.Map;

class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
public class Solution {
//    Map<Node,Node> nodeMap = new HashMap<>();
//    public Node copyRandomList(Node head) {
//        if(head == null) return null;
//        if(!nodeMap.containsKey(head)){
//            Node newNode = new Node(head.val);
//            nodeMap.put(head,newNode);
//            newNode.next = copyRandomList(head.next);
//            newNode.random = nodeMap.getOrDefault(head.random, null);
//        }
//        return nodeMap.get(head);
//    }


    public Node copyRandomList(Node head) {
        Map<Node,Node> map = new HashMap<>();
        Node headCopy = head;
        Node h = new Node(-1);
        Node cur = h;
        while (head!= null){
            Node newNode = new Node(head.val);
            map.put(head,newNode);
            cur.next = newNode;
            cur = cur.next;
            head = head.next;
        }
        cur = h.next;
        while (headCopy!= null){
            cur.random = map.get(headCopy.random);
            cur = cur.next;
            headCopy = headCopy.next;
        }
        return h.next;
    }

}
