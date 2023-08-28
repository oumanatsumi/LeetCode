package Q1_500.Q146;

import java.util.HashMap;
import java.util.Map;

class LRUCache {

    class DLinkNode{
        int key;
        int val;
        DLinkNode next;
        DLinkNode prev;

        public DLinkNode(int _key, int _val){
            this.key = _key;
            this.val = _val;
            this.next = null;
            this.prev = null;
        }
    }

    Map<Integer, DLinkNode> nodeMap = new HashMap<>();
    DLinkNode dummyHead, dummyTail;
    int size = 0;
    int capacity = 0;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        dummyHead = new DLinkNode(-1,-1);
        dummyTail = new DLinkNode(-1,-1);
        dummyHead.next = dummyTail;
        dummyTail.prev = dummyHead;
    }

    public int get(int key) {
        if(!nodeMap.containsKey(key) || nodeMap.get(key) == null){
            return -1;
        }
        int res = nodeMap.get(key).val;
        moveToEnd(nodeMap.get(key));
        return res;
    }

    public void put(int key, int value) {
        if(!nodeMap.containsKey(key))
        {
            DLinkNode node = new DLinkNode(key, value);
            addNode(node);
            nodeMap.put(key, node);
            size ++;
            if(size > capacity){
                nodeMap.remove(dummyHead.next.key);
                deleteNode(dummyHead.next);
                size--;
            }
        }
        else {
            nodeMap.get(key).val= value;
            moveToEnd(nodeMap.get(key));
        }
    }

    public void deleteNode(DLinkNode node){
        node.next.prev = node.prev;
        node.prev.next = node.next;
    }

    public void addNode(DLinkNode node){
        nodeMap.put(node.key, node);
        dummyTail.prev.next = node;
        node.prev = dummyTail.prev;
        node.next = dummyTail;
        dummyTail.prev = node;
    }

    public void moveToEnd(DLinkNode node){
        deleteNode(node);
        addNode(node);
    }

    public static void main(String[] args) {
        LRUCache lRUCache = new LRUCache(2);
        System.out.println(lRUCache.get(2)); // 缓存是 {1=1}
        lRUCache.put(2, 6); // 缓存是 {1=1, 2=2}
        System.out.println(lRUCache.get(1));    // 返回 1
        lRUCache.put(1, 5); // 该操作会使得关键字 2 作废，缓存是 {1=1, 3=3}
        lRUCache.put(1, 2); // 该操作会使得关键字 2 作废，缓存是 {1=1, 3=3}
        System.out.println(lRUCache.get(1));    // 返回 -1 (未找到)
        System.out.println(lRUCache.get(2));    // 返回 4
    }
}