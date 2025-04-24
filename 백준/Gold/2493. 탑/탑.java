import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        Stack<Node> stack = new Stack<>();
        int[] answer = new int[N];
        for(int i=0; i<N; i++) {
            int now = Integer.parseInt(st.nextToken());
            while(!stack.isEmpty()) {
                Node temp = stack.peek();
                if(temp.value > now) {
                    answer[i] = temp.idx;
                    stack.add(new Node(i+1, now));
                    break;
                } else {
                    stack.pop();
                }
            } 
            stack.add(new Node(i+1, now));
        }
        

        for(int i=0; i<N; i++) {
            System.out.print(answer[i] + " ");
        }

    }
        
    public static class Node {
        int idx;
        int value;

        public Node(int idx, int value) {
            this.idx = idx;
            this.value = value;
        }
    }
}