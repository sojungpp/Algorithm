import java.util.*;

class Solution {
    int max;
    Map<String, Integer> map;
    public String[] solution(String[] orders, int[] course) {
        List<String> answer = new ArrayList<>();
        
        for(int num : course) {
            map = new HashMap<>();
            max = 0;
            
            for(String order : orders) {
                char[] orderArray = order.toCharArray();
                Arrays.sort(orderArray);
                order = new String(orderArray);
                
                dfs(-1, "", order, num);
            }
            
            for(String key : map.keySet()) {
                if(map.get(key) == max && map.get(key) >= 2) {
                    answer.add(key);
                }   
            }
        }
        
        Collections.sort(answer);
        return answer.toArray(new String[answer.size()]);
    }
    
    private void dfs(int index, String target, String order, int course) {
        if(target.length() == course) {
            map.put(target, map.getOrDefault(target, 0)+1);
            max = Math.max(max, map.get(target));
        }
        
        for(int i=index+1; i<order.length(); i++) {
            dfs(i, target+order.charAt(i), order, course);
        }
    }
}