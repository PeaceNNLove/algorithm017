package Week_01.homework;

//给定一个链表，两两交换其中相邻的节点，并返回交换后的链表。
//
// 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
//
//
//
// 示例:
//
// 给定 1->2->3->4, 你应该返回 2->1->4->3.
//
// Related Topics 链表
// 👍 632 👎 0

/**
 * @author linhongxiang
 * @since 2020/9/24
 */
public class SwapPairs {
    /**
     * 递归法
     */
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        return swap(head, head.next);
    }

    /**
     * 1. 数据单元是两个节点
     * 2. 第一个节点指向第二个节点后面已经交换好的节点
     * 3. 第二个节点指向第一个节点
     * 4. 返回第二个节点
     */
    public ListNode swap(ListNode first, ListNode second) {
        // 1. 终结条件
        if (first == null || second == null) {
            return first;
        }
        // 2. 执行操作
        // 3. 进入下一层
        first.next = swap(second.next, second.next != null ? second.next.next : null);
        // 4. 清理操作
        second.next = first;
        return second;
    }

    /**
     * 迭代法
     */
    public ListNode swapPairs2(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode newList = new ListNode(-1);
        ListNode temp = newList;
        ListNode first = head;
        ListNode second = head.next;
        while (first != null && second != null) {
            first.next = second.next;
            second.next = first;
            temp.next = second;
            temp = first;
            first = temp.next;
            second = temp.next == null ? null : temp.next.next;
        }
        return newList.next;
    }
}
