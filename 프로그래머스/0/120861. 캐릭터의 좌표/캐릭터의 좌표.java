class Solution {
    int[] standard;
    
    private boolean check(int x, int y){
        if(x>standard[0]/2 || y>standard[1]/2 || x<-standard[0]/2 || y<-standard[1]/2) return false;
        return true;
    }
    
    public int[] solution(String[] keyinput, int[] board) {
        this.standard = board;
        int[] answer = {0, 0};
        for(String k : keyinput){
            switch(k){
                case "left": 
                    if(check(answer[0]-1, answer[1])) answer[0] -= 1;
                    break;
                case "right":
                    if(check(answer[0]+1, answer[1])) answer[0] += 1;
                    break;
                case "up":
                    if(check(answer[0], answer[1]+1)) answer[1] += 1;
                    break;
                case "down":
                    if(check(answer[0], answer[1]-1)) answer[1] -= 1;
                    break;
                default:
                    break;
            };
        };
        return answer;
    }
}
