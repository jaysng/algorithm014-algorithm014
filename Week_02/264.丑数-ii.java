/*
 * @lc app=leetcode.cn id=264 lang=java
 *
 * [264] 丑数 II
 */

// @lc code=start
class Solution {
    public int nthUglyNumber(int n) {
        int a = 0, b = 0, c = 0;
        int[] uns = new int[n];
        uns[0] = 1;
        for (int i = 1; i < n; i++) {
            int n2 = uns[a] * 2, n3 = uns[b] * 3, n5 = uns[c] * 5;
            uns[i] = Math.min(Math.min(n2,n3),n5);
            if(uns[i]==n2) a++;
            if(uns[i]==n3) b++;
            if(uns[i]==n5) c++;
        }
        return uns[n-1];
    }
}
// @lc code=end
