package 移动零;

/**
 * @ProjectName: algorithm014-algorithm014
 * @ClassName: Solution
 * @Description:
 * @Author: Damon Sng
 * @CreateDate: 2020/8/16 6:49 PM
 * @UpdateUser:
 * @UpdateDate: 2020/8/16 6:49 PM
 * @UpdateRemark:
 * @Version: 1.0
 */
//class Solution {
//    public void moveZeroes(int[] nums) {
//        int zeroIndex = 0;
//        for (int i = 0; nums.length > 1 && i < nums.length; i++) { //nums.length>1条件其实不应该结果
//            if (nums[i] != 0) { //相比第二种方法多一个变量
//                int temp = nums[zeroIndex];
//                nums[zeroIndex++] = nums[i];
//                nums[i] = temp;
//            }
//        }
//    }
//}

class Solution {
    public void moveZeroes(int[] nums) {
        int zeroIndex = -1;
        for (int i = 0; nums.length > 1 && i < nums.length; i++) {
            if(nums[i] == 0 ){ //连续0的时候索引值不变
                zeroIndex = zeroIndex == -1 ? i : zeroIndex;
            }else if(zeroIndex > -1){
                nums[zeroIndex++] = nums[i];
                nums[i] = 0;
            }
        }
    }
}