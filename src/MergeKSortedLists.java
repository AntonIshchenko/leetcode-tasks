import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class MergeKSortedLists {

    public ListNode mergeKLists(ListNode[] lists) {
        if (!checkIfPresent(lists)) {
            return null;
        }
        Map<Integer, Integer> minAndPos = getMinAndPos(lists);
        Integer minVal = minAndPos.keySet().stream().findFirst().get();
        Integer minPos = minAndPos.get(minVal);
        ListNode currentNode = new ListNode();
        ListNode result = new ListNode(minVal, currentNode);
        lists[minPos] = lists[minPos].next;
        int resultSize = 1;

        while (checkIfPresent(lists)) {
            Map<Integer, Integer> minAndPos1 = getMinAndPos(lists);
            Integer minVal1 = minAndPos1.keySet().stream().findFirst().get();
            Integer minPos1 = minAndPos1.get(minVal1);
            currentNode.val = minVal1;
            resultSize++;
            lists[minPos1] = lists[minPos1].next;
            if (checkIfPresent(lists)) {
                currentNode.next = new ListNode();
                currentNode = currentNode.next;
            }
        }
        if(resultSize == 1) {
            result.next = null;
        }
        return result;
    }

    private Map<Integer, Integer> getMinAndPos(ListNode[] lists) {
        TreeMap<Integer, Integer> valMap = new TreeMap<>();
        for (int i = 0; i < lists.length; i++) {
            if (lists[i] != null) {
                valMap.put(lists[i].val, i);
            }
        }
        Map<Integer, Integer> result = new HashMap<>();
        valMap.keySet().stream().findFirst().ifPresent(val -> result.put(val, valMap.get(val)));

        return result;
    }

    private boolean checkIfPresent(ListNode[] lists) {
        if (lists.length == 0) {
            return false;
        }
        int nullCnt = 0;
        for (ListNode list : lists) {
            if (list == null) {
                nullCnt++;
            }
        }
        if (nullCnt == lists.length) {
            return false;
        }
        return true;
    }
}
