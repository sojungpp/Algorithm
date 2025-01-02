import java.util.*;

class Solution {
    public int[] solution(String s) {
        LinkedHashSet<Integer> set = new LinkedHashSet<>();
        String[] inputs = s.replaceAll("[{]", " ").replaceAll("[}]", " ").trim().split(" , ");
        Arrays.sort(inputs, (a, b) -> {
            return a.length() - b.length();
        });

        for(String input : inputs) {
            String[] nums = input.split(",");
            for(String num : nums) {
                set.add(Integer.parseInt(num));
            }
        }

        return set.stream().mapToInt(Integer::intValue).toArray();
    }
}