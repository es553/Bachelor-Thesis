package leetcode_buggy_version.java_bugg;

public class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if ((nums[i] + nums[j]) == target) {
                    return nums;
                }
            }
        }
        return null;
    }
}

// https://leetcode.com/problems/two-sum/solutions/5050238/code-in-java/
// Error: return nums;
