import java.awt.List;
import java.util.ArrayList;
/*
 * @lc app=leetcode.cn id=589 lang=java
 *
 * [589] N叉树的前序遍历
 */

// @lc code=start
/*
// Definition for a Node.
class Node {
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
*/

class Solution {
    public List<Integer> preorder(Node root) {
        List<Integer> list = new ArrayList<>();
        helper(root, list);
        return list;
    }

    void helper(Node node, List list) {
        if (node != null) {
            list.add(node.val);
            for (Node chi : node.children) {
                helper(chi, list);
            }
        }
    }
}
// @lc code=end
