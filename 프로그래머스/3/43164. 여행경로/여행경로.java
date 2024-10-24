import java.util.*;

class Solution {
    
    boolean[] visited;
    String[][] tickets;
    
    public String[] solution(String[][] tickets) {
        this.tickets = tickets;
        
        Arrays.sort(this.tickets, (a, b) -> a[0].equals(b[0]) ? a[1].compareTo(b[1]) : a[0].compareTo(b[0]));
        
        List<String> answer = new ArrayList<>();
        for(int i=0; i<tickets.length; i++) {
            if(tickets[i][0].equals("ICN")) {
                visited = new boolean[tickets.length];
                visited[i] = true;
                List<String> list = new ArrayList<>();
                list.add(tickets[i][0]);
                list = dfs(i, list);

                
                if(list.size() == tickets.length+1) {
                    if(answer.isEmpty() || isFirst(list, answer) < 0) answer = list;
                }
            }
        }
        return answer.toArray(new String[0]);
    }
    
    private int isFirst(List<String> list, List<String> answer) {
        for(int i=0; i<list.size(); i++) {
            int temp = list.get(i).compareTo(answer.get(i));
            if(temp != 0) return temp;
        }
        return 0;
    }
    
    private List<String> dfs(int index, List<String> list) {
        list.add(tickets[index][1]);
        if(isFinished()) return list;

        for(int i=0; i<tickets.length; i++) {
            if(!visited[i] && tickets[i][0].equals(tickets[index][1])) {
                visited[i] = true;
                List<String> result = dfs(i, list);
                if(isFinished()) return result;
                visited[i] = false;
                list.remove(list.size()-1);
            }
        }
        return list;
    }
    
    private boolean isFinished() {
        for(int i=0; i<visited.length; i++) {
            if(!visited[i]) return false;
        }
        return true;
    }
}