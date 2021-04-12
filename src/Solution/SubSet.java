package Solution;

import java.util.*;
import java.util.stream.Collectors;

public class SubSet {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new LinkedList<>();
        LinkedList<Integer> item = new LinkedList<>();
        Map<String, String> map = new HashMap<>();
        ans.add(new ArrayList<>());
        ans.add(Arrays.stream(nums).boxed().collect(Collectors.toList()));

        return ans;
    }

    private void backTrace(
            List<List<Integer>> ans,
            LinkedList<Integer> item,
            Map<String, String> map,
            int[] nums,
            int idx) {

        for (int i = 0; i < nums.length; i++) {

        }

    }
}
