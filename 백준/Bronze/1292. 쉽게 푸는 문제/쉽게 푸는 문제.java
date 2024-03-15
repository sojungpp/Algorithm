import java.util.*;

class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int to = sc.nextInt();
        int from = sc.nextInt();
        int[] array = new int[1000000];
        int cnt = 1;
    
        for(int i=1; i<=1000; i++){
            for(int j=0; j<i; j++){
                array[cnt] = i;
                cnt++;
            }
        }
        
        int answer = 0;
        for(int i=to; i<=from; i++){
            answer += array[i];
        }
        System.out.println(answer);
    }
}