package Week_01.homework;

/**
 * @author linhongxiang
 * @since 2020/9/27
 */
public class ReverseList {
    /**
     * 方法一：
     * 不断的创建一个新的节点，成为第一个元素的上一层元素
     * 将第二个元素的值赋给新节点
     */
    public ListNode reverseList(ListNode head) {
        ListNode current = null;
        ListNode prev = head;
        while (prev != null) {
            ListNode temp = prev.next;
            prev.next = current;
            current = prev;
            prev = temp;
        }
        return current;
    }
}
