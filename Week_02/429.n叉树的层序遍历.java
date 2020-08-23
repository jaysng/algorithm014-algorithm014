import java.awt.List;
import java.util.ArrayList;

/*
 * @lc app=leetcode.cn id=429 lang=java
 *
 * [429] N叉树的层序遍历
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
    List<List<Integer>> list = new ArrayList<>();
    public List<List<Integer>> levelOrder(Node root) {
        int level = 0;
        if(root!=null) helper(root,level);
        return list;
    }

    void helper(Node node,int level){
        if(list.size()<= level){
            list.add(new ArrayList<>());
        }
        list.get(level).add(node.val);
        for(Node _node : node.children){
            helper(_node, level+1);
        }
    }
}
// @lc code=end

