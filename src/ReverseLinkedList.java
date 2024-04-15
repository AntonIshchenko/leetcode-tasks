import java.util.List;

public class ReverseLinkedList {
    public ListNode reverseList(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode rezult = new ListNode(head.val, null);
        head = head.next;
        while (head != null) {
            rezult = new ListNode(head.val, rezult);
            head = head.next;
        }
        return rezult;
    }
}
