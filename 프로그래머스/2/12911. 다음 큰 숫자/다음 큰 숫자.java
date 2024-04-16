class Solution {
    public int solution(int n) {
        
        String binarynum = Integer.toBinaryString(n);
        int oneNumStand = binarynum.length() - binarynum.replace("1", "").length();
        // 조건 1
        for(int i=n+1; i<=1000000; i++){
            // 조건 2
            String iToString = Integer.toBinaryString(i);
            int oneNum = iToString.length() - iToString.replace("1", "").length();
            if(oneNum == oneNumStand) return i;
        }
        return -1;
    }
}