import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    static Map<Integer, Integer> map;
    static List<Integer> answer;
    static boolean[] visited;
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        
        visited = new boolean[N+1];
        map = new HashMap<>();
        for(int i=1; i<=N; i++) {
            int input = Integer.parseInt(br.readLine());
            map.put(i, input);
        }
        
        answer = new ArrayList<>();
        for(int i=1; i<=N; i++) {
            visited[i] = true;
            dfs(i, i);
            visited[i] = false;
        }
        System.out.println(answer.size());
        for(Integer i : answer) {
            System.out.println(i);
        }
    }

    private static void dfs(int value, int target) {
        if(!visited[map.get(value)]) {
            visited[map.get(value)] = true;
            dfs(map.get(value), target);
            visited[map.get(value)] = false;
        }
        if(map.get(value) == target) answer.add(target);
    }

}