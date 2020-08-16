/**
 * @ProjectName: algorithm014-algorithm014
 * @ClassName: Solution
 * @Description:
 * @Author: Damon Sng
 * @CreateDate: 2020/8/16 9:12 PM
 * @UpdateUser:
 * @UpdateDate: 2020/8/16 9:12 PM
 * @UpdateRemark:
 * @Version: 1.0
 */


//记录左边最高的柱子高度，依次向右推进，找到比左边最高柱子更高的柱子，得到面积后减去中间所有柱子的高度总和
//当出现一直到最右侧都没有比左边高的柱子时，中间出现凹槽则无法被统计到
//双指针，从坐开始向右收集，当height[i]比height[height.length-1]高时，则从右开始往左收集；来回递推
class Solution {
    //索引坐标
    int a = -1;
    //从左边开始
    int b = 0;
    int c = 0;
    int d = -1;
    int area = 0;
    int leftHeightCount = 0;
    int rightHeightCount = 0;

    public int trap(int[] height) {
        c = height.length - 1;
        while (b < c - 1) {
            if (height[b] < height[c]) { //从左边开始
                countLeftArea(height);
            } else {//从右边开始
                countRightArea(height);
            }
        }
        return area;

    }

    void countLeftArea(int[] height) {
        int m = a > -1 ? a : 0;
        leftHeightCount = 0;
        if (height[b] >= height[c]) {
            countRightArea(height);
        }
        for (int i = m; i <= c && a < c; i++) {
            if (height[b] > height[c]) {
                countRightArea(height);
            }
            if(b >=c){
                break;
            }
            if (height[i] > 0 && a < 0) {//
                a = i;
            } else if (a > -1 && height[i] < height[a]) { //记录a和b之间柱子高度总和
                leftHeightCount = leftHeightCount + height[i];
            } else if (a > -1 && height[i] >= height[a]) {
                b = i;
                if (b - a > 1) { //b的高度比a高且不是相邻的2个柱子，计算面积
                    area = area + (b - a - 1) * height[a] - leftHeightCount;
                    leftHeightCount = 0;
                    a = b;
                    if (height[a] >= height[c]) {
                        countRightArea(height);
                    }
                }
                a = b;
            }
        }
    }

    void countRightArea(int[] height) {
        int m = d > -1 ? d : height.length - 1;
        leftHeightCount = 0;
        if (height[b] < height[c]) {
            countLeftArea(height);
        }
        for (int i = m; i >= b && a < c; i--) {
            if (height[b] < height[c]) {
                countLeftArea(height);
            }
            if(b >=c){
                break;
            }
            if (height[i] > 0 && d < 0) {
                d = i;
            } else if (d > -1 && height[i] < height[d]) { //记录a和b之间柱子高度总和
                leftHeightCount = leftHeightCount + height[i];
            } else if (d > -1 && height[i] >= height[d]) {
                c = i;
                if (d - c > 1) { //b的高度比a高且不是相邻的2个柱子，计算面积
                    area = area + (d - c - 1) * height[d] - leftHeightCount;
                    leftHeightCount = 0;
                    d = c;
                    int temp = a < 0 ? 0 : a;
                    if (height[c] > height[temp]) {
                        countLeftArea(height);
                    }
                }
                d = c;
            }
        }
    }
}




//俄罗斯方块消层算法，复杂度可能较高，果然超时了，无语！！！时间复杂度o(n^n)
// class Solution {
//     public int trap(int[] height) {
//         int a = 0;
//         int b = height.length - 1;
//         int area = 0;
//         while (a < b) {
//             if (height[a] == 0) {
//                 a++;
//             } else if (height[b] == 0) {
//                 b--;
//             } else if (height[a] != 0 && height[b] != 0) { // 找到边界时，计算为0的个数，即这一层能接到的雨水数量,且所有非0的柱子消除一行
//                 for (int i = a; i <= b; i++) {
//                     if (height[i] == 0) {
//                         area++;
//                     } else {
//                         height[i]--;
//                     }
//                 }
//             }
//         }
//         return area;
//     }
// }