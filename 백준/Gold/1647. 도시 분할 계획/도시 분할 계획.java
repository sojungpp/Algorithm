import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    static int[] parent;
    public static void main(String[] args) throws Exception {
        // N개 집, M개 길
        // 분리된 두 마을 사이에 있는 길 없애기
        // 분리된 마을 안에서 연결되는거 빼고 없애기
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] graph = new int[M][3];
        for(int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine());
            graph[i][0] = Integer.parseInt(st.nextToken())-1;
            graph[i][1] = Integer.parseInt(st.nextToken())-1;
            graph[i][2] = Integer.parseInt(st.nextToken());
        }
        // 오름차순
        Arrays.sort(graph, (o1, o2) -> Integer.compare(o1[2], o2[2]));

        parent = new int[N];
        for(int i=0; i<N; i++) {
            parent[i] = i;
        }

        // 크루스칼 알고리즘 (마을 전체 연결하기)
        int max = 0;
        int answer = 0;
        for(int i=0; i<M; i++) {
            if(find(graph[i][0]) != find(graph[i][1])) {
                union(graph[i][0], graph[i][1]);
                answer += graph[i][2];
                max = Math.max(graph[i][2], max);
            }
        }
        
        // 유지비엥서 최대 유지 길 빼기 (마을 2개로 분리하기)
        System.out.println(answer - max);
    }

    private static void union(int a, int b) {
        a = find(a);
        b = find(b);
        if(a>b) parent[a] = b;
        else parent[b] = a;
    }
    
    private static int find(int target) {
        if(parent[target] == target) return target;
        else return find(parent[target]);
    }
}