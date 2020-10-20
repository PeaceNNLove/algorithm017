package Week_03.homework.tree.domain;

import java.util.List;

/**
 * @author linhongxiang
 * @since 2020/9/29
 */
public class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};