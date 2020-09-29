package Week_02.homework;

import Week_02.homework.tree.domain.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author linhongxiang
 * @since 2020/9/29
 */
public class InorderTraversal {
    /**
     * 第一次尝试
     */
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if (root == null) {
            return new ArrayList<>();
        }
        if (root.left == null && root.right == null) {
            list.add(root.val);
            return list;
        }
        list.addAll(inorderTraversal(root.left));
        list.add(root.val);
        list.addAll(inorderTraversal(root.right));
        return list;
    }

    /**
     * 基于第一次的优化.
     * 优化点，只创建一个list对象
     */
    public List<Integer> inorderTraversal2(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        traversal(root, list);
        return list;
    }

    public void traversal(TreeNode root, List<Integer> list) {
        if (root == null) {
            return;
        }
        traversal(root.left, list);
        list.add(root.val);
        traversal(root.right, list);
    }
}
