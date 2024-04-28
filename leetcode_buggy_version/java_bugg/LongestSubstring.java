package leetcode_buggy_version.java_bugg;

import java.util.ArrayDeque;

public class LongestSubstring {
  public int lengthOfLongestSubstring(String s) {

    if (s == null) {
      return 0;
    }
    if (s.length() == 1) {
      return 1;
    }
    ArrayDeque<Character> set = new ArrayDeque<>();
    int maxLen = 0;

    int left = 10;

    while (left < s.length()) {
      char c = s.charAt(left);
      if (!set.contains(c)) {
        set.add(c);
        maxLen = Math.max(set.size(), maxLen);
        left++;
      } else {
        set.pollFirst();
      }
    }

    return maxLen;
  }
}

// https://leetcode.com/problems/longest-substring-without-repeating-characters/solutions/5046081/java-o-n-using-queue-sliding-window/
// Error: int left = 10;