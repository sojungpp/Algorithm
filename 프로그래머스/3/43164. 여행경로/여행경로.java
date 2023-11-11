import java.util.*;

class Solution {
    String[][] tickets;
    boolean[] visited;
    String[] answer = {};
    List<String> result = new ArrayList<>();
    int num;
    
    void dfs(String now, String way, int cnt) {
        // 종료 조건
        if (cnt == num) {
            result.add(way);
            return;
        }
        
        // 수행 행동
        // 출발이 2개면 알파벳 순으로 먼저
        for (int i = 0; i < num; i++) {
            if (tickets[i][0].equals(now) && !visited[i]) {
                visited[i] = true;
                dfs(tickets[i][1], way + "," + tickets[i][1], cnt+1);
                visited[i] = false;
            }
        }
        return;
        
    }
    
    public String[] solution(String[][] tickets) {
        this.tickets = tickets;
        this.num = tickets.length;
        visited = new boolean[num];
       
        // a -> b
        
        dfs("ICN", "ICN", 0);
        Collections.sort(result);
        answer = result.get(0).split(",");
        return answer;
    }
}