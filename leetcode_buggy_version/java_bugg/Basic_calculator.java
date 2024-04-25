package leetcode_buggy_version.java_bugg;

// https://leetcode.com/problems/basic-calculator/solutions/5046444/simple-and-intuitive-java-code/
import java.util.Stack;

public class Basic_calculator {
  public int calculate(String s) {
    // prioritize the (, if they are present
    if (s == null)
      return 0;
    s = s.replaceAll(" ", "");
    int sum = 0;
    int openBracketIndex = s.indexOf("(");
    if (openBracketIndex == -1) {
      // no bracket, so simple parsing and find the solution
      sum = evaluate(s);
    } else {
      Stack stack = new Stack();
      for (char c : s.toCharArray()) {

        if (c == ')') {
          String temp = "";
          while ((char) stack.peek() != '(') {
            temp = (char) stack.pop() + temp;
          }
          stack.pop();// remove (
          String newItem = String.valueOf(evaluate(temp));
          for (char n : newItem.toCharArray()) {
            stack.push(n);
          }
          continue;
        }
        stack.push(c);
      }
      String result = "";
      while (!stack.isEmpty()) {
        result = stack.pop() + result;
      }

      sum = evaluate(result);
    }
    return sum;
  }

  int evaluate(String s) {

    int sum = 0;
    String temp = "";
    char lastOperator = '\0';
    for (int i = 0; i < s.length(); i++) {
      char c = s.charAt(i);
      if (c == '+' || c == '-') {
        if (lastOperator == '\0' && !temp.equals("")) {
          sum += Integer.valueOf(temp);
        } else {
          if (lastOperator == '+' && !temp.equals("")) {
            sum += Integer.valueOf(temp);
          } else if (lastOperator == '-' && !temp.equals("")) {
            sum -= Integer.valueOf(temp);
          }
        }
        char nextChar = s.charAt(i + 1);
        lastOperator = getNextOperator(c, nextChar);
        if (nextChar == '+' || nextChar == '-')
          i++;// skip next
        temp = "";
        continue;
      }
      temp += String.valueOf(c);
    }

    if (lastOperator == '\0') {
      sum += Integer.valueOf(temp);
    } else {
      if (lastOperator == '+') {
        sum += Integer.valueOf(temp);
      } else if (lastOperator == '-') {
        sum -= Integer.valueOf(temp);
      }
    }
    return sum;
  }

  char getNextOperator(char a, char b) {

    if (b != '+' && b != '-')
      return a;
    if (a == b)
      return '+';
    return '-';
  }
}
