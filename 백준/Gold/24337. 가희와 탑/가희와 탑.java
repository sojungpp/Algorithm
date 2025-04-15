import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        List<Integer> list = new ArrayList<>();
        if(a+b-1 > N) {
            System.out.println(-1);
            return;
        }

        // 1부터 증가하면서 a전까지 채우기
        for(int i=1; i<a; i++) {
            list.add(i);
        }

        // 최대높이(a/b) 자리 채우기
        list.add(Math.max(a, b));

        // b부터 감소하면서 채우기
        for(int i=b-1; i>0; i--) {
            list.add(i);
        }

        // 남은 빈 자리 1로 채우기 (첫 번째 자리부터! 0번째 하면 X)
        for(int i=0; i<N-(a+b-1); i++) {
            list.add(1, 1);
        }

        for (int n: list) {
            System.out.print(n + " ");
        }
    }
}