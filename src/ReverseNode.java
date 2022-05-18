import myclass.Node;

/**
 * @author
 * @Description 反转链表
 * @create 2022-05-07 9:54
 */

public class ReverseNode {
    //时间复杂度O（n）,递归，DFS
    private Node reversalHead;
    public Node reversal(Node head){
        if (head == null || head.next == null){
            return head;
        }

        reverse(head,head.next);
        head.next = null;
        return reversalHead;
    }
    private void reverse(Node father,Node son){
        if (son.next == null){
            son.next = father;
            reversalHead = son;
            return ;
        }
        reverse(son,son.next);
        son.next = father;
    }
}
