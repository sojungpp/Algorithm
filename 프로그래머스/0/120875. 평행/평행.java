class Solution {
    
    private boolean check(int[] a, int[] b, int[] c, int[] d){
        double AB = (double)(a[0] - b[0]) / (double)(a[1] - b[1]);
        double CD = (double)(c[0] - d[0]) / (double)(c[1] - d[1]);
        return AB == CD;
    }
 
    public int solution(int[][] dots) {
        if(check(dots[0], dots[1], dots[2], dots[3])) return 1;
        if(check(dots[0], dots[2], dots[1], dots[3])) return 1;
        if(check(dots[0], dots[3], dots[1], dots[2])) return 1;
        return 0;
    }
}