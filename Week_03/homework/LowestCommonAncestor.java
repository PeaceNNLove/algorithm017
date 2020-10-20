package Week_03.homework;

import Week_03.homework.tree.domain.TreeNode;

/**
 * 问题分析：
 * 1. 先找到p,q的位置，然后回溯找到父节点
 * 2. 最近公共父节点可以是自己本身
 */
public class LowestCommonAncestor {

    private TreeNode target = null;

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        find(root, p, q);
        return target;
    }

    public boolean find(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return false;
        }
        /*
         * 后序遍历
         */
        boolean lson = find(root.left, p, q);
        boolean rson = find(root.right, p, q);
        /*
         * 1. 如果左子树或者右子树中找到了p和q，那么现在这个节点就是最近父节点
         * 2. 如果自己本身就是p或q，那么只要自己的左右子树中含有相对的另外一个节点p或q，那么当前节点就是最近父节点
         */
        if ((lson && rson) || ((root.val == p.val || root.val == q.val) && (lson || rson))) {
            target = root;
        }
        return lson || rson || root.val == p.val || root.val == q.val;
    }
}
