import java.util.*;

class Solution {
    boolean[] visited;
    List<String> answer;
    String[][] tickets;
    
    public String[] solution(String[][] tickets) {
        visited = new boolean[tickets.length];
        answer = new ArrayList<>();
        this.tickets = tickets;
        
        dfs("ICN", "ICN", 0);
        
        Collections.sort(answer);
        return answer.get(0).split(" ");
    }
    
    private void dfs(String city, String route, int cnt) {
        if(cnt == tickets.length) {
            answer.add(route);
            return;
        }
        
        for(int i=0; i<tickets.length; i++) {
            if(!visited[i] && tickets[i][0].equals(city)) {
                visited[i] = true;
                dfs(tickets[i][1], route + " " + tickets[i][1], cnt+1);
                visited[i] = false;
            }
        }
        return;
    }
}