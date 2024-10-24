import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int N = Integer.parseInt(br.readLine());
        int[] cards = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        for(int i=0; i<N; i++) {
            cards[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(cards);
            
        int M = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());

        for(int i=0; i<M; i++) {
            int target = Integer.parseInt(st.nextToken());
            bw.write(findEndIdx(cards, target) - findFirstIdx(cards, target) + " ");
        }
        bw.flush();
    }

    private static int findFirstIdx(int[] cards, int target) {
        int left = 0;
        int right = cards.length;
        
        while(left != right) {
            int mid = (left+right)/2;
            if(cards[mid] >= target) right = mid;
            else left = mid+1;
        }
        return left;
    }
    
    private static int findEndIdx(int[] cards, int target) {
        int left = 0;
        int right = cards.length;
        
        while(left != right) {
            int mid = (left+right)/2;
            if(cards[mid] > target) right = mid;
            else left = mid+1;
        }
        return left;
    }
}