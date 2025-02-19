import java.util.*;

class Solution {
    boolean[] visited;
    Set<Set<String>> set;
    String[] user_id, banned_id;
    
    public int solution(String[] user_id, String[] banned_id) {
        this.user_id = user_id;
        this.banned_id = banned_id;
        this.set = new HashSet<>();
        this.visited = new boolean[user_id.length];
        
        dfs(0, new HashSet<String>());
        
        return set.size();
    }
    
    private void dfs(int depth, Set<String> temp) {
        if(depth == banned_id.length) {
            set.add(new HashSet<>(temp));
            return;
        }
        
        for(int i=0; i<user_id.length; i++) {
            if(visited[i] || !check(user_id[i], banned_id[depth])) continue;
            visited[i] = true;
            temp.add(user_id[i]);
            dfs(depth+1, temp);
            temp.remove(user_id[i]);
            visited[i] = false;
        }
    }
    
    private boolean check(String target, String value) {
        if(target.length() != value.length()) return false;

        for(int i=0; i<target.length(); i++) {
            if(value.charAt(i) != '*' && target.charAt(i) != value.charAt(i)) {
                return false;
            }
        }
        return true;
    }
}