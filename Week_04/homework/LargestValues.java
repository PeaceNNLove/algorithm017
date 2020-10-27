package Week_04.homework;

import Week_04.homework.domain.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class LargestValues {
    public List<Integer> largestValues(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        List<Integer> list = new ArrayList<>();
        Deque<TreeNode> deque = new ArrayDeque<>();
        deque.addFirst(root);
        while (deque.size() > 0) {
            int size = deque.size();
            int max = deque.peekFirst().val;
            for (int i = 0; i < size; i++) {
                TreeNode node = deque.pollLast();
                max = node.val > max ? node.val : max;
                if (node.left != null) {
                    deque.addFirst(node.left);
                }
                if (node.right != null) {
                    deque.addFirst(node.right);
                }
            }
            list.add(max);
        }
        return list;
    }
}
