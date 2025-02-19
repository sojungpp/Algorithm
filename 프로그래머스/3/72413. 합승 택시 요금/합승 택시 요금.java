import java.util.*;

class Solution {
    int[][] taxi;
    int n;
    
    public int solution(int n, int s, int a, int b, int[][] fares) {
        
        this.taxi = new int[n+1][n+1];
        this.n = n;
        
        for(int[] fare : fares) {
            taxi[fare[0]][fare[1]] = fare[2];
            taxi[fare[1]][fare[0]] = fare[2];
        }
        
        int[] together = dijkstra(s);
        int[] aloneA = dijkstra(a);
        int[] aloneB = dijkstra(b);
        
        int answer = Integer.MAX_VALUE;
        for(int i=1; i<=n; i++) {
            answer = Math.min(answer, together[i] + aloneA[i] + aloneB[i]);
        }
        
        return answer;
    }
    
    private int[] dijkstra(int start) {
        PriorityQueue<Node> q = new PriorityQueue<>(Comparator.comparingInt(a -> a.money));
        int[] taxiMoney = new int[n+1];
        Arrays.fill(taxiMoney, Integer.MAX_VALUE);
        
        taxiMoney[start] = 0;
        q.add(new Node(start, 0));
        
        while(!q.isEmpty()) {
            Node temp = q.poll();
            for(int i=1; i<=n; i++) {
                if(taxi[temp.now][i] != 0 && taxiMoney[i] > taxi[temp.now][i]+temp.money) {
                    taxiMoney[i] = taxi[temp.now][i] + temp.money;
                    q.add(new Node(i, taxiMoney[i]));
                }
            }
        }
        return taxiMoney;
    }
    
    public class Node {
        int now;
        int money;
        
        public Node(int now, int money) {
            this.now = now;
            this.money = money;
        }
    }

}