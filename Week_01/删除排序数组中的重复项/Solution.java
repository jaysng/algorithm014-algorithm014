class Solution {

    public int removeDuplicates(int[] nums) {
        int count = nums.length > 0 ? 1: 0;
        for (int i : nums)
            if (i > nums[count-1])
                nums[count++] = i;
        return count;
    }

    // public int removeDuplicates(int[] nums) {
    //     if (nums.length <= 1) {
    //         return nums.length;
    //     }
    //     int count = 0;
    //     for (int i = 0; i < nums.length - 1; i++) {
    //         if (nums[i] != nums[i + 1]) {
    //             nums[++count] = nums[i + 1];
    //         }
    //     }
    //     return ++count;
    // }
}