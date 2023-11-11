class Solution {
    public int solution(int m, int n, int[][] puddles) {
        
        int[][] ways = new int[n+1][m+1];
        for(int i=0; i<puddles.length; i++) {
            int y = puddles[i][0];
            int x = puddles[i][1];
            ways[x][y] = -100; // puddles
        }
        
        ways[1][1] = 1;
        // m = 4, n = 3
        for (int i=1; i<n+1; i++) {
            for (int j=1; j<m+1; j++) {
                if (ways[i][j] == -100) {
                    ways[i][j] = 0;
                    continue;
                }
                
                if (i-1 != 0) ways[i][j] += ways[i-1][j] % 1000000007;
                if (j-1 != 0) ways[i][j] += ways[i][j-1] % 1000000007;
            
            }
        }
        return ways[n][m] % 1000000007;
    }
}