class Solution {
    public int[] solution(int brown, int yellow) {
        int sum = brown + yellow;
        for(int i=1; i<Integer.MAX_VALUE; i++){
            for(int j=1; j<=i; j++){
                if(brown == 2*i + 2*j - 4 && i*j == sum) return new int[]{i, j};
            }
        }
        return new int[]{};
    }
}