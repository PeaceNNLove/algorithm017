package Week_02.homework;

import Week_02.homework.tree.domain.Node;

import java.util.ArrayList;
import java.util.List;

//给定一个 N 叉树，返回其节点值的前序遍历。
//
// 例如，给定一个 3叉树 :
//
//
//
//
//
//
//
// 返回其前序遍历: [1,3,5,6,2,4]。
//
//
//
// 说明: 递归法很简单，你可以使用迭代法完成此题吗? Related Topics 树

/**
 * @author linhongxiang
 * @since 2020/9/29
 */
public class Preorder {
    public List<Integer> preorder(Node root) {
        List<Integer> list = new ArrayList<>();
        traversal(root, list);
        return list;
    }

    public void traversal(Node root, List<Integer> list) {
        if (root == null) {
            return;
        }
        list.add(root.val);
        if (root.children != null) {
            for (int i = 0; i < root.children.size(); i++) {
                traversal(root.children.get(i), list);
            }
        }
    }
}
