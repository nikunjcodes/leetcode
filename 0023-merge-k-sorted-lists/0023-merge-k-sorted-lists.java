import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        List<Integer> ans = new ArrayList<>();
        for (ListNode li : lists) {
            while (li != null) {
                ans.add(li.val);
                li = li.next;
            }
        }
        if (ans.isEmpty()) {
            return null;
        }
        Collections.sort(ans);
        ListNode head = new ListNode(ans.get(0));
        ListNode temp = head;
        for (int i = 1; i < ans.size(); i++) {
            temp.next = new ListNode(ans.get(i));
            temp = temp.next;
        }
        return head;
    }
}
