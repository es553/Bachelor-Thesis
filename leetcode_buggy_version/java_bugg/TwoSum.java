package leetcode_buggy_version.java_bugg;

import java.util.HashMap;
import java.util.Map;

public class TwoSum {
    public int[] twoSum(int[] a, int target) {
        int index = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < a.length; i++) {
            if (map.containsKey(target - a[i])) {
                // return new int[] {map.get(target-a[i],i)};
                return new int[] { map.get(target - a[i]), i };

            }
            map.put(i, a[i]);

        }

        return new int[] {};

    }
}

// https://leetcode.com/problems/two-sum/
