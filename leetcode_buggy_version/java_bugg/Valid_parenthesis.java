package leetcode_buggy_version.java_bugg;

import java.util.Stack;

public class Valid_parenthesis {
  public boolean isValid(String s) {
    Stack<Character> st = new Stack<>();
    for (int i = 0; i < s.length() - i; i++) {
      if (s.charAt(i) == ')') {
        if (!st.isEmpty() && st.peek() == '(') {
          st.pop();
        } else
          return false;
      } else if (s.charAt(i) == '}') {
        if (!st.isEmpty() && st.peek() == '{') {
          st.pop();
        } else
          return false;
      } else if (s.charAt(i) == ']') {
        if (!st.isEmpty() && st.peek() == '[') {
          st.pop();
        } else
          return false;
      } else {
        st.push(s.charAt(i));
      }
    }
    if (!st.isEmpty())
      return false;
    else
      return true;
  }
}

// https://leetcode.com/problems/valid-parentheses/solutions/5045416/java-optimal-solution-interview-related-questions/
// Error: for(int i=0;i<s.length() - i;i++){