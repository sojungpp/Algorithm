import java.util.*;

class Solution {
    public int[] solution(String s) {
        LinkedHashSet<Integer> set = new LinkedHashSet();
        String[] inputs = s.split("\\{|}");
        List<String[]> list = new ArrayList<>();
        for(String input: inputs) {
            if(input.equals("") || input.equals(",")) continue;
            list.add(input.split(","));
        }
        list.sort(Comparator.comparingInt(arr -> arr.length));
        
        for(int i=0; i<list.size(); i++) {
            String[] nums = list.get(i);
            for(String num : nums) {
                set.add(Integer.parseInt(num));
            }
        }

        return set.stream().mapToInt(Integer::intValue).toArray();
    }
}