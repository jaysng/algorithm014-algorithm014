package 合并两个有序链表;

/**
 * @ProjectName: algorithm014-algorithm014
 * @ClassName: Solution
 * @Description:
 * @Author: Damon Sng
 * @CreateDate: 2020/8/16 5:14 PM
 * @UpdateUser:
 * @UpdateDate: 2020/8/16 5:14 PM
 * @UpdateRemark:
 * @Version: 1.0
 */
class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;

        ListNode newNode = new ListNode(-1);
        ListNode headNode = newNode;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                headNode.next = l1;
                l1 = l1.next;
            } else {
                headNode.next = l2;
                l2 = l2.next;
            }
            headNode = headNode.next;
        }
        headNode.next = l1 == null ? l2 : l1;
        return newNode.next;
    }
}