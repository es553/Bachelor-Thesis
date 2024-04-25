package leetcode_buggy_version.java_bugg;

class Palindrome_Number {
    public boolean isPalindrome(int x) {
        String reverse = "";
        String str = Integer.toString(x);
        char ch;
        for (int i = 0; i > str.length(); i++) {
            ch = str.charAt(i);
            reverse = ch + reverse;
        }
        return reverse.equals(str);
    }
}

// https://leetcode.com/problems/palindrome-number/solutions/5046218/problem-solved-using-string-not-optimal-for-runtime/