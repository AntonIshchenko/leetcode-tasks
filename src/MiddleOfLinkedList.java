public class MiddleOfLinkedList {


    public class ListNode {
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

    public ListNode middleNode(ListNode head) {
        ListNode node = head;
        int cnt = 0;
        while (node.next != null) {
            node = node.next;
            cnt++;
        }
        Double ceil = Math.ceil(cnt / 2.0);
        node = head;
        for (int i = 0; i < ceil.intValue(); i++) {
            node = node.next;
        }
        return node;
    }
}
