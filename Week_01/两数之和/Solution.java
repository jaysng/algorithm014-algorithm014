package 两数之和;

import java.util.HashMap;
import java.util.Map;

/**
 * @ProjectName: algorithm014-algorithm014
 * @ClassName: Solution
 * @Description:
 * @Author: Damon Sng
 * @CreateDate: 2020/8/16 6:20 PM
 * @UpdateUser:
 * @UpdateDate: 2020/8/16 6:20 PM
 * @UpdateRemark:
 * @Version: 1.0
 */
class Solution {
    public int[] twoSum(int[] nums, int target) throws IllegalArgumentException {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int b = target - nums[i];
            if (map.containsKey(b)) {
                return new int[]{ map.get(b),i};
            }
            map.put(nums[i],i);
        }
        throw new IllegalArgumentException("不存在");
    }
}