package Week_02.homework;

import Week_02.homework.tree.domain.Node;

import java.util.*;

//给定一个 N 叉树，返回其节点值的层序遍历。 (即从左到右，逐层遍历)。
//
// 例如，给定一个 3叉树 :
//
// 返回其层序遍历:
//
// [
//     [1],
//     [3,2,4],
//     [5,6]
//]
//
// 说明:
//
//
// 树的深度不会超过 1000。
// 树的节点总数不会超过 5000。
// Related Topics 树 广度优先搜索

/**
 * @author linhongxiang
 * @since 2020/9/29
 */
public class LevelOrder {
    /**
     * 首次解题：
     * 利用一个HashMap存储每一层的元素列表。
     * 递归获取每一层的元素。
     *
     * 看完答案后想法，ArrayList本身就是有序的，可以节省HashMap的空间和时间。
     */
    public List<List<Integer>> levelOrder(Node root) {
        Map<Integer, List<Integer>> cache = new HashMap<>();
        traversal(root, cache, 0);
        return new ArrayList<>(cache.values());
    }

    public void traversal(Node root, Map<Integer, List<Integer>> cache, Integer level) {
        if (root == null) {
            return;
        }
        List<Integer> levelList;
        if (cache.containsKey(level)) {
            levelList = cache.get(level);
        } else {
            levelList = new ArrayList<>();
        }
        levelList.add(root.val);
        cache.put(level, levelList);
        root.children.forEach(node -> traversal(node, cache, level + 1));
    }
}
