import java.util.*;

class Solution {
    int[] parent;
    public int solution(int n, int[][] costs) {
        
        parent = new int[n];
        for(int i=0; i<n; i++) {
            parent[i] = i;
        }
        Arrays.sort(costs, (a, b) -> a[2] - b[2]);
        
        int answer = 0;
        for(int[] cost : costs) {
            if(find(cost[0]) != find(cost[1])) {
                union(cost[0], cost[1]);
                answer += cost[2];
            }
        }
        return answer;      
    }
    
    private int find(int target) {
        if(parent[target] == target) return target;
        else return parent[target] = find(parent[target]);
    }
    
    private void union(int a, int b) {
        a = find(a);
        b = find(b);
        if(a != b) parent[b] = a;
    }
}