import java.util.*;

class Solution {
    public String solution(int[] numbers) {
        PriorityQueue<String> pq = new PriorityQueue<>(new Comparator<String>() {
    	@Override
		public int compare(String a, String b) {
    		return (a+b).compareTo(b+a);
        	}
    	});
        
        for(int n : numbers){
            pq.add(String.valueOf(n));
        }
        
        String answer = "";
        while(!pq.isEmpty()){
            answer = pq.poll() + answer;
        }
        
        if(answer.replace("0","").length() == 0) return "0";
        return answer;
    }
}