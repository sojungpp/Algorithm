import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int answer = 0;
        Stack<Integer> stack = new Stack<>();
        
        for(int i=0; i<n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int point = Integer.parseInt(st.nextToken());
            int height = Integer.parseInt(st.nextToken());
            
            if(height == 0) {
                answer += stack.size();
                stack.clear();
            }
            else if(!stack.isEmpty()) {
                int temp = stack.peek();
                // 더 높은 경우
                if(temp < height) stack.push(height);
                else {
                    // 더 낮은 경우
                    // 높은 건물들 정답 추가
                    while(!stack.isEmpty() && stack.peek() > height) {
                        stack.pop();
                        answer++;
                    }
                    // 스택에 없는 높이인 경우
                    if(!stack.contains(height)) stack.push(height);
                }
            } 
            // 스택이 비어있는 경우
            else stack.push(height);
        }
        answer += stack.size();
        System.out.println(answer);
    }
}