import java.util.*;
import java.lang.*;
import java.io.*;


class Main {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        String[] array = s.split(" ");
        int N = Integer.parseInt(array[0]);
        int X = Integer.parseInt(array[1]);

        int[] visitor = new int[N];
        String visitorNum = br.readLine();
        String[] arr = visitorNum.split(" ");
        for(int i=0; i<N; i++){
            visitor[i] = Integer.parseInt(arr[i]);
        }

        // 첫 번째 구간
        int max = 0;
        int periodNum = 1;
        for(int i=0; i<X; i++){
            max += visitor[i];
        }
        
        int temp = max;
        // 이후 구간
        for(int i=X; i<N; i++){
            // 다음 일자 더하고 가장 왼쪽 일자 빼기
            temp = temp - visitor[i-X] + visitor[i];
            if(temp == max) periodNum += 1;
            else if(temp > max) {
                max = temp;
                periodNum = 1;
            }
        }

        if(max == 0) System.out.println("SAD");
        else { 
            System.out.println(max);
            System.out.println(periodNum);
        }
    }
}