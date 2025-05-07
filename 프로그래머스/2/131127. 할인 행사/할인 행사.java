import java.util.*;

// 일정금액 지불하면 10일동안 회원 자격
// 매일 한 가지 제품 할인, 하나만 구매 가능
// 정현이는 10일 연속 일치할 때 회원가입
class Solution {
    
    Map<String, Integer> map;
    Set<String> set;
    
    public int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;
        int right = 9;
        map = new HashMap<>();
        set = new HashSet<>();
        
        for(int i=0; i<want.length; i++) {
            map.put(want[i], number[i]);
            set.add(want[i]);
        }
        
        
        for(int i=0; i<=right; i++) {
            map.put(discount[i], map.getOrDefault(discount[i], 0)-1);
        }
        
        while(right != discount.length-1) {
            if(isValid()) answer++;
            map.put(discount[right-9], map.getOrDefault(discount[right-9], 0)+1);
            map.put(discount[right+1], map.getOrDefault(discount[right+1], 0)-1);
            right++;
        }
        if(isValid()) answer++;
        return answer;
    }
    
    private boolean isValid() {
        List<String> keyList = new ArrayList<>(map.keySet());
        for(String k : keyList) {
            if(!set.contains(k)) continue;
            if(map.get(k) != 0) return false;
        }
        return true;
    }
}