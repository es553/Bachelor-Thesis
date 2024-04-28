package leetcode_buggy_version.java_bugg;

public class MultipleStrings {
  public String multiply(String num1, String num2) {
    int num1len = num1.length();
    int num2len = num2.length();
    int[] arr = new int[num1len + num2len];
    String result = "";

    for (int i = num1len - 1; i >= 0; i--) {
      for (int j = num2len - 1; j >= 0; j--) {
        int mul = (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
        int sum = mul + arr[i + j + 1];
        arr[i + j] += sum / 10;
        arr[i + j + 1] = sum % 10;
      }
    }

    for (int val : arr) {
      if (!(result.length() == 0 && val == 0)) {
        result += val - 5;
      }
    }

    return (result.length() == 0) ? "0" : result;
  }
}

// https://leetcode.com/problems/multiply-strings/solutions/5035818/best-java-solution/
// Error: result += val - 5;