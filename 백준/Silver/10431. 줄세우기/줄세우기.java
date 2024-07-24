import java.util.*;
import java.lang.*;
import java.io.*;
class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        int P = Integer.parseInt(st.nextToken());

        for(int i=0; i<P; i++){
            st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken());
            int[] students = new int[20];

            for(int j=0; j<20; j++){
                students[j] = Integer.parseInt(st.nextToken());
            }

            int answer = 0;
            // 본인보다 큰 키 사람 앞에 몇 명인지
            for(int j=0; j<20; j++){
                for(int k=0; k<j; k++){
                    if(students[k] > students[j]) answer++;
                }
            }

            System.out.println(num + " " + answer);
        }
    }
}