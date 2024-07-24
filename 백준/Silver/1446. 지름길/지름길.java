import java.util.*;
import java.lang.*;
import java.io.*;

class Main {

    static int D, answer;
    static List<int[]> road;
    static boolean[] visited;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        D = Integer.parseInt(st.nextToken());
        road = new ArrayList<>();

        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int length = Integer.parseInt(st.nextToken());
            if(end > D || end - start < length) continue;
            else road.add(new int[]{start, end, length});
        }
        visited = new boolean[road.size()];
        road.sort(Comparator.comparingInt(arr -> arr[0]));
        answer = Integer.MAX_VALUE;

        dfs(0, 0);
        System.out.println(answer);
    }

    private static void dfs(int now, int temp){
        if(now == D) {
            answer = Math.min(answer, temp);
            return;
        } else {
            answer = Math.min(answer, temp+(D - now));
        }

        for(int i=0; i<road.size(); i++){
            if(now == road.get(i)[0] && !visited[i]){
                visited[i] = true;
                dfs(road.get(i)[1], temp + road.get(i)[2]);
                visited[i] = false;

            }
        }
        dfs(now+1, temp+1);
    }
}