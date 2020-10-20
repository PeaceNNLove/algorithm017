package Week_03.homework;

import Week_03.homework.tree.domain.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * 问题分析：
 * 1. 只要在中序遍历中找到根节点，那么就可以知道左子树和右子树的数量
 * 2. 而前序遍历是先遍历根节点，可以利用前序遍历的顺序，在中序遍历结果中搜索，找到各个根节点，构造其左右子树。
 * 3. 通过中序遍历知道了左子树的数量和右子树的数量，那么回到前序遍历，在前序遍历中,左子树包含的所有节点区间就是[根节点位置 + 1, 根节点位置 + 1+ 左子树数量]，右子树同理
 */
public class BuildTree {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        Map<Integer, Integer> rootIndexMap = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            rootIndexMap.put(inorder[i], i);
        }
        return myBuildTree(preorder, rootIndexMap, 0, preorder.length - 1, 0);
    }

    /**
     * 分治
     * 1. 找到根节点
     * 2. 构建左子树
     * 3. 构建右子树
     * 4. 合成一棵树
     *
     * @param preorder 前序排列顺序
     * @param map       中序排列，节点和索引映射
     * @param preorderLeft   在前序排列中，树节点左区间
     * @param preorderRight  在前序排列中，树节点右区间
     * @param inorderLeft    当前树在中序排列中的起点
     * @return 树
     */
    public TreeNode myBuildTree(int[] preorder, Map<Integer, Integer> map, int preorderLeft, int preorderRight, int inorderLeft) {
        // 终结条件
        if (preorderLeft > preorderRight) {
            return null;
        }
        // 找到根节点
        Integer inorderRoot = map.get(preorder[preorderLeft]);
        TreeNode rootNode = new TreeNode(preorder[preorderLeft]);
        // 左子树的节点数目
        int leftTreeSize = inorderRoot - inorderLeft;
        // 构建左子树
        TreeNode leftTree = myBuildTree(preorder, map, preorderLeft + 1, preorderLeft + leftTreeSize, inorderLeft);
        // 构建右子树
        TreeNode rightTree = myBuildTree(preorder, map, preorderLeft + leftTreeSize + 1, preorderRight, inorderRoot + 1);
        rootNode.left = leftTree;
        rootNode.right = rightTree;
        return rootNode;
    }
}
