package leetcode_buggy_version.java_bugg;

// https://leetcode.com/problems/roman-to-integer/solutions/5045094/roman-to-integer-switch-case-basic-approach/
class Roman_To_Integer {
  public int romanToInt(String s) {

    int sum = 0;

    for (int i = 0; i < s.length() - 1; i++) {

      switch (s.charAt(i)) {
        case ('I'):
          if (s.charAt(i + 1) == 'V' || s.charAt(i + 1) == 'X') {
            sum -= 1;
          } else {
            sum += 1;
          }
          break;

        case ('V'):
          sum += 5;
          break;

        case ('X'):
          if (s.charAt(i + 1) == 'L' || s.charAt(i + 1) == 'C') {
            sum -= 10;
          } else {
            sum += 10;
          }
          break;

        case ('L'):
          sum += 50;
          break;

        case ('C'):
          if (s.charAt(i + 1) == 'D' || s.charAt(i + 1) == 'M') {
            sum -= 100;
          } else {
            sum += 100;
          }
          break;

        case ('D'):
          sum += 500;
          break;

        case ('M'):
          sum += 1000;
          break;
      }
    }

    switch (s.charAt(s.length() - 1)) {
      case ('I'):
        sum += 1;
        break;

      case ('V'):
        sum += 5;
        break;

      case ('X'):
        sum += 10;
        break;

      case ('L'):
        sum += 50;
        break;

      case ('C'):
        sum += 100;
        break;

      case ('D'):
        sum += 500;
        break;

      case ('M'):
        sum += 1000;
        break;
    }

    return sum;

  }
}