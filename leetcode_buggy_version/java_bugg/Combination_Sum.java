package leetcode_buggy_version.java_bugg;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

// https://leetcode.com/problems/combination-sum/solutions/5044704/java/
public class Combination_Sum {

  HashSet<ArrayList<Integer>> hm = new HashSet<>();

  public void combinationSum(int candidates[], int sum, ArrayList<Integer> list, int index) {

    if (sum == 0) {
      hm.add(new ArrayList<Integer>(list));
      return;

    }
    if (sum < 0) {
      return;
    }
    for (int i = index; i < candidates.length; i++) {
      int s = sum - candidates[i];
      list.add(candidates[i]);
      combinationSum(candidates, s, list, i);
      list.remove(list.size() - 1);

    }
  }

  public List<List<Integer>> combinationSum(int[] candidates, int target) {
    int sum = target;
    combinationSum(candidates, sum, new ArrayList<Integer>(), 0);
    List<List<Integer>> listall = new ArrayList<>(hm);
    return listall;
  }
}
