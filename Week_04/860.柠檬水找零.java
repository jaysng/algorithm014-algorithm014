/*
 * @lc app=leetcode.cn id=860 lang=java
 *
 * [860] 柠檬水找零
 */

// @lc code=start
class Solution {
    public boolean lemonadeChange(int[] bills) {
        int five = 0, ten = 0;
        for (int i : bills) {
            if (i == 5)
                five++;
            else if (i == 10) {
                five--;
                ten++;
            } else if (i == 20) {
                if (ten == 0) {
                    five = five - 3;
                } else {
                    ten--;
                    five--;
                }
            }
            if (five < 0) return false;
        }
        return true;
    }
}
// @lc code=end
