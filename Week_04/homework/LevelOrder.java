package Week_04.homework;

import Week_04.homework.domain.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * List<List<Integer>> allResults = new ArrayList<>();
 *     if (root == null) {
 *         return allResults;
 *     }
 *     Queue<TreeNode> nodes = new LinkedList<>();
 *     nodes.add(root);
 *     while (!nodes.isEmpty()) {
 *         int size = nodes.size();
 *         List<Integer> results = new ArrayList<>();
 *         for (int i = 0; i < size; i++) {
 *             TreeNode node = nodes.poll();
 *             results.add(node.val);
 *             if (node.left != null) {
 *                 nodes.add(node.left);
 *             }
 *             if (node.right != null) {
 *                 nodes.add(node.right);
 *             }
 *         }
 *         allResults.add(results);
 *     }
 *     return allResults;
 */
public class LevelOrder {
    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        List<List<Integer>> lists = new ArrayList<>();
        Deque<TreeNode> deque = new ArrayDeque<>();
        deque.addLast(root);
        while (deque.size() != 0) {
            List<Integer> list = new ArrayList<>();
            int currentFloorSize = deque.size();
            while (currentFloorSize > 0) {
                TreeNode node = deque.pollFirst();
                list.add(node.val);
                if (node.left != null) {
                    deque.addLast(node.left);
                }
                if (node.right != null) {
                    deque.addLast(node.right);
                }
                currentFloorSize --;
            }
            lists.add(list);
        }
        return lists;
    }
}
