package Week_01.homework;
//将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
//
// 
//
// 示例： 
//
// 输入：1->2->4, 1->3->4
//输出：1->1->2->3->4->4
// 
// Related Topics 链表 
// 👍 1279 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
/**
 * @author linhongxiang
 * @since 2020/9/24
 */
public class MergeTwoList {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode mergeList = new ListNode(-1);
        ListNode temp = mergeList;
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                temp.next = l1;
                l1 = l1.next;
            } else {
                temp.next = l2;
                l2 = l2.next;
            }
            temp = temp.next;
        }
        temp.next = l1 == null ? l2 : l1;
        return mergeList.next;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}