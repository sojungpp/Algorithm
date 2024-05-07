class Solution{
    public int solution(int n, int a, int b){
        int answer = 1;
        
        if(a>b){
            int temp = a;
            a = b;
            b = temp;
        }
        System.out.println(a);
        while(b != a+1 || a%2 == 0){
            System.out.println("-");
            if(a%2 == 0) a /= 2;
            else a = a/2 + 1;
            
            if(b%2 == 0) b /= 2;
            else b = b/2 + 1;
            
            answer++;
        }
        return answer;
    }
}