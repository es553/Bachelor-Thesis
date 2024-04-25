package leetcode_buggy_version.java_bugg;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

// https://leetcode.com/problems/word-ladder/solutions/5028873/java-intuitive-bfs/
public class Word_Ladder {
  public int ladderLength(String beginWord, String endWord, List<String> wordList) {
    HashSet<String> validWords = new HashSet<>();
    for (String word : wordList)
      validWords.add(word);

    if (!validWords.contains(endWord))
      return 0;

    Queue<String> q = new LinkedList<>();
    q.add(beginWord);
    HashSet<String> seen = new HashSet<>();
    seen.add(beginWord);
    int transformation = 1;

    while (!q.isEmpty()) {
      int size = q.size();
      while (size-- > 0) {
        String word = q.poll();
        if (word.equals(endWord))
          return transformation;

        for (String w : wordList) {
          if (!seen.contains(w) && ifDifferenceIsSingleCharOrLess(word, w)) {
            seen.add(w);
            q.add(w);
          }
        }
      }
      transformation++;
    }
    return 0;
  }

  private boolean ifDifferenceIsSingleCharOrLess(String word, String w) {
    if (word.length() != w.length())
      return false;
    int diff = 0;
    for (int i = 0; i < word.length(); i++) {
      if (word.charAt(i) != w.charAt(i))
        diff++;
    }
    return diff <= 1 ? true : false;
  }
}
