import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=94 lang=java
 *
 * [94] 二叉树的中序遍历
 */

// @lc code=start
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        helper(root,list);
        return list;
    }

    void helper(TreeNode node,List list){
        if (node!=null) {
            helper(node.left, list);
            list.add(node.val);
            helper(node.right, list);
        }
    }
}
// @lc code=end

