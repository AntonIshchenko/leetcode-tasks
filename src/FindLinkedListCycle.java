public class FindLinkedListCycle {

    public ListNode detectCycle(ListNode head) {
        ListNode slow = head, fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                break;
            }
        }

        if (fast == null || fast.next == null) {
            return null;
        }

        while (head != slow) {
            head = head.next;
            slow = slow.next;
        }
        return head;
    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public static void main(String[] args) {
        FindLinkedListCycle.ListNode input = createInput();
        FindLinkedListCycle.ListNode listNode = new FindLinkedListCycle().detectCycle(input);
        System.out.println(listNode == null ? null : listNode.val);
    }

    private static FindLinkedListCycle.ListNode createInput() {
        FindLinkedListCycle.ListNode listNode = new FindLinkedListCycle.ListNode(1);
        listNode.next = new FindLinkedListCycle.ListNode(2,
                new FindLinkedListCycle.ListNode(3,
                        new FindLinkedListCycle.ListNode(4,
                                new FindLinkedListCycle.ListNode(6,
                                        null))));
        listNode.next.next.next.next.next = listNode.next.next.next;
        return listNode;
    }
}
