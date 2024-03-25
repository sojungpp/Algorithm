import java.util.*;

class Solution {
    
    static int answer = Integer.MAX_VALUE;
    static int temp, standard;
    static boolean[] visited;
    static ArrayList<String> picksList = new ArrayList<>();
    static String[] minerals;
    
    private void dfs(int index){
        if(temp >= answer) return;
        
        if(index == standard){
            answer = Math.min(temp, answer);
            return;
        }
        
        for(int i=0; i<picksList.size(); i++){
            if(!visited[i]){
                int sum = calc(picksList.get(i), index);
                temp += sum;
                visited[i] = true;
                dfs(index+1);
                temp -= sum;
                visited[i] = false;
            }
        }
        
        
    }
    
    private int calc(String pick, int index){
        index = index*5;
        int endIndex = Math.min(index+5, minerals.length);
        int sum = 0;
        for(int i=index; i<endIndex; i++){
            if(pick.equals("iron") && minerals[i].equals("diamond")) sum += 5;
            else if(pick.equals("stone") && minerals[i].equals("iron")) sum += 5;
            else if(pick.equals("stone") && minerals[i].equals("diamond")) sum += 25;
            else sum++;
        }
        return sum;
    }
    
    
    
    public int solution(int[] picks, String[] minerals) {
        this.minerals = minerals;
        // 곡갱이 리스트
        for(int i=0; i<picks[0]; i++){
            picksList.add("diamond");
        }
        for(int i=0; i<picks[1]; i++){
            picksList.add("iron");
        }
        for(int i=0; i<picks[2]; i++){
            picksList.add("stone");
        }
        
        visited = new boolean[picksList.size()];
        standard = Math.min((int)Math.ceil((double) minerals.length/5), picks[0]+picks[1]+picks[2]);
        
        dfs(0);
        
        return answer;
    }
}