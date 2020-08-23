import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/*
 * @lc app=leetcode.cn id=347 lang=java
 *
 * [347] 前 K 个高频元素
 */

// @lc code=start
class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> hashmap = new HashMap<>();
        for (int i : nums) {
            int count = hashmap.containsKey(i) ? hashmap.get(i) + 1 : 1;
            hashmap.put(i, count);
        }
        PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                // TODO Auto-generated method stub
                return hashmap.get(o1) - hashmap.get(o2);
            }

        });

        for (Integer key : hashmap.keySet()) {
            if (pq.size() < k) {
                pq.add(key);
            } else if (hashmap.get(key) > hashmap.get(pq.peek())) {
                pq.remove();
                pq.add(key);
            }
        }
        int[] resultInt = new int[k];
        while (!pq.isEmpty()) {
            resultInt[--k] = pq.poll();
        }
        return resultInt;
    }
}
// @lc code=end
