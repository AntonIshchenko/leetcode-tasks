import java.util.ArrayList;
import java.util.List;

public class PalindromeLinkedList {

    public boolean isPalindrome(ListNode head) {
        ListNode currNode = head;
        List<Integer> list = new ArrayList<>();
        while (currNode != null) {
            list.add(currNode.val);
            currNode = currNode.next;
        }
        int size = list.size();
        List<Integer> list1 = list.subList(0, size / 2);
        List<Integer> list2 = null;
        if (size % 2 == 0) {
            list2 = list.subList(size / 2, size);
        } else {
            list2 = list.subList(size / 2 + 1, size);
        }
        int result = 0;
        for (int i = 0; i < size / 2; i++) {
            result += Math.abs(list1.get(i) - list2.get(size / 2 - 1 - i));
        }
        return result == 0;
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
}
