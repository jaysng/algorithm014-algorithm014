package 合并两个有序数组;

/**
 * @ProjectName: algorithm014-algorithm014
 * @ClassName: Solution
 * @Description:
 * @Author: Damon Sng
 * @CreateDate: 2020/8/16 5:16 PM
 * @UpdateUser:
 * @UpdateDate: 2020/8/16 5:16 PM
 * @UpdateRemark:
 * @Version: 1.0
 */
class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {

        int p = m-- + n-- - 1;

        while ( m > -1 && n > -1 ) {
            if (nums1[m] < nums2[n]) {
                nums1[p--] = nums2[n--];
            } else {
                nums1[p--] = nums1[m--];
            }
        }
        while(n>-1){
            nums1[p--] = nums2[n--];
        }
    }
}
