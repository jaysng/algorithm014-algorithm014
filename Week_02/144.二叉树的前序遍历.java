/*
 * @lc app=leetcode.cn id=144 lang=java
 *
 * [144] 二叉树的前序遍历
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
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        helper(root,list);
        return list;
    }

    void helper(TreeNode node ,List list ){
        if (node!=null) {
            list.add(node.val);
            helper(node.left, list);
            helper(node.right, list);
        }
    }
}
// @lc code=end

