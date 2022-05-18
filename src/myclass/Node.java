package myclass;

/**
 * @author
 * @Description
 * @create 2022-05-07 9:51
 */
public class Node {
    public int val;
    public Node next;

    public Node() {
    }

    public Node(int val) {
        this.val = val;
    }

    public Node(Node next) {
        this.next = next;
    }

    public Node(int val, Node next) {
        this.val = val;
        this.next = next;
    }
}
