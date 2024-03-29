class Solution {
    public String solution(String polynomial) {
        
        String[] strs = polynomial.split(" ");
        int x = 0;
        int num = 0;
        for(String s : strs){
            if(s.contains("x")) {
                if(s.equals("x")) x++;
                else x += Integer.parseInt(s.replace("x", ""));
            }
            else if(!s.contains("+")) num += Integer.parseInt(s);
        }
        if(num==0) {
            if(x==1) return "x";
            else return x + "x";
        }
        else if(x==0) return String.valueOf(num);
        else {
            if(x==1) return "x" + " + " + num;
            else return x + "x" + " + " + num;
        }
    }
}