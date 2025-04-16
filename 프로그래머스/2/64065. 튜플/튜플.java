import java.util.*;

class Solution {
    public int[] solution(String s) {
        s = s.replaceAll("\\{\\{", "").replaceAll("\\}\\}", "").replaceAll("\\},\\{", "/");
        String[] lists = s.split("/");
        
        Map<Integer, List<Integer>> map = new HashMap<>();
        for(String l : lists) {
            String[] nums = l.split(",");
            List<Integer> list = new ArrayList<>();
            for(String n : nums) {
                list.add(Integer.parseInt(n));
            }
            map.put(nums.length, list);
        }
        
        int[] answer = new int[map.size()];
        Set<Integer> set = new HashSet<>();
        for(int i=0; i<map.size(); i++) {
            List<Integer> temp = map.get(i+1);
            for(Integer t : temp) {
                if(!set.contains(t)) {
                    answer[i] = t;
                    set.add(t);
                    break;
                }
            }
        }
        return answer;
    }
}