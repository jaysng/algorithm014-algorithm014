import java.util.Arrays;

/*
 * @lc app=leetcode.cn id=242 lang=java
 *
 * [242] 有效的字母异位词
 */

// @lc code=start
class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        int[] countArray = new int[26];
        for (int i = 0; i < s.length(); i++) {
            countArray[s.charAt(i) - 'a']++;
            countArray[t.charAt(i) - 'a']--;
        }
        for (int i : countArray) {
            if (i != 0) {
                return false;
            }
        }
        return true;
    }
}
// @lc code=end
