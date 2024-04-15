public class AddTwoNumbers {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode result = null;
        ListNode currentNode = new ListNode();
        int addititon = 0;
        int sss = add(l1, l2, addititon);
        while (sss >= 0) {

            int sum = sss;

//            sum += addititon;
            l1 = l1 == null ? null : l1.next;
            l2 = l2 == null ? null : l2.next;
            if (sum > 9) {
                sum -= 10;
                addititon = 1;
            } else {
                addititon = 0;
            }
            sss = add(l1, l2, addititon);
            if (result == null) {
                if (l1 == null && l2 == null) {
                    result = new ListNode(sum, null);
                } else {
                    result = new ListNode(sum, currentNode);
                }
                continue;
            }
            currentNode.val = sum;
            if (sss >= 0) {
                currentNode.next = new ListNode();
            } else {
                currentNode.next = null;
            }
            currentNode = currentNode.next;
        }

        return result;
    }

    private int add(ListNode l1, ListNode l2, Integer add) {
        int sum = 0;
        if (l1 != null) {
            sum += l1.val;
        }
        if (l2 != null) {
            sum += l2.val;
        }
        if (l1 == null && l2 == null && add == 0) {
            return -1;
        }
        if (l1 == null && l2 == null) {
            return add;
        }
        return sum + add;
    }
}
