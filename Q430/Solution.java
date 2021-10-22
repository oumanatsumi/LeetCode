package Q430;

// Definition for a Node.
class Node {
    public int val;
    public Node prev;
    public Node next;
    public Node child;
};

class Solution {
    public Node flatten(Node head) {
        dfs(head);
        return head;
    }

    public Node dfs(Node node) {
        Node cur = node;
        Node last = null;
        
        while(cur != null)
        {
            Node next = cur.next;

            if(cur.child != null)
            {
                Node childLast = dfs(cur.child);
                
                next = cur.next;
                cur.next = cur.child;
                cur.child.prev = cur;

                if(next != null)
                {
                    childLast.next = next;
                    next.prev = childLast;
                }
                cur.child = null;
                last = childLast;
            }
            else
            {
                last = cur;
            }
            cur = next;
        }
        return last;
        
    }
}

