import java.util.*;

public class Main {
    public static void main(String[] args) {
        Stack<Integer> s = new Stack<>();
        Scanner sc = new Scanner(System.in);
        int K = sc.nextInt();
        int sum = 0;

        for(int i=0; i<K; i++){
            int num = sc.nextInt();
            if(num == 0) s.pop();
            else s.add(num);
        }
        
        while(!s.empty()) sum = sum + s.pop();
        System.out.println(sum);
    }
}