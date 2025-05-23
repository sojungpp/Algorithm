import java.util.*;

class Solution {
    int[] parent;
    public int solution(int n, int[][] costs) {
        // 오름차순
        Arrays.sort(costs, (o1, o2) -> Integer.compare(o1[2], o2[2]));
        
        parent = new int[n];
        for(int i=0; i<n; i++) {
            parent[i] = i;
        }
        
        int answer = 0;
        for(int i=0; i<costs.length; i++) {
            if(find(costs[i][0]) != find(costs[i][1])) {
                union(costs[i][0], costs[i][1]);
                answer += costs[i][2];
            }
        }
        
        return answer;
    }
    
    private void union(int a, int b) {
        a = find(a);
        b = find(b);
        if(a > b) parent[a] = b;
        else parent[b] = a;
    }
    
    private int find(int target) {
        if(parent[target] == target) return target;
        else return find(parent[target]);
    }
}