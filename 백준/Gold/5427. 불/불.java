import java.util.*;
import java.lang.*;
import java.io.*;

class Main {
    /*
    '.': 빈 공간
    '#': 벽
    '@': 상근이의 시작 위치
    '*': 불
    */
    static int h, w;
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for(int t=0; t<T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            w = Integer.parseInt(st.nextToken());
            h = Integer.parseInt(st.nextToken());
            String[][] maps = new String[h][w];
            boolean[][] visited = new boolean[h][w];
            boolean[][] fireVisited = new boolean[h][w];
            Queue<int[]> q = new LinkedList<>();
            Queue<int[]> fire = new LinkedList<>();
            int answer = Integer.MAX_VALUE;
            int[] dx = {1, 0, -1, 0};
            int[] dy = {0, 1, 0, -1};
            int day = 0;
            
            for(int i=0; i<h; i++) {
                String input = br.readLine();
                String[] inputs = input.split("");
                for(int j=0; j<w; j++) {
                    maps[i][j] = inputs[j];
                    if (maps[i][j].equals("@")) {
                        visited[i][j] = true;
                        q.add(new int[]{i, j, 0});
                    }
                    if (maps[i][j].equals("*")) {
                        fire.add(new int[]{i, j, 0});
                    }
                }
            }

            while(!q.isEmpty()) {
                // 불
                int size = fire.size();
                for(int i=0; i<size; i++) {
                    int[] tempFire = fire.poll();
                    for(int j=0; j<4; j++) {
                            int tempFireX = tempFire[0] + dx[j];
                            int tempFireY = tempFire[1] + dy[j];
                            if(isValid(tempFireX, tempFireY) && (maps[tempFireX][tempFireY].equals(".") || maps[tempFireX][tempFireY].equals("@"))) {
                                maps[tempFireX][tempFireY] = "*";
                                fire.add(new int[]{tempFireX, tempFireY, 0});
                            }
                        }
                }

                size = q.size();
                for(int i=0; i<size; i++) {
                    int[] temp = q.poll();

                    if(isExit(temp[0], temp[1])) {
                        answer = Math.min(answer, temp[2]);
                        continue;
                    }

                    if(temp[2] >= answer) continue;

                    for(int j=0; j<4; j++) {
                        int tempX = temp[0] + dx[j];
                        int tempY = temp[1] + dy[j];
    
                        if(isValid(tempX, tempY) && maps[tempX][tempY].equals(".") && !visited[tempX][tempY]) {
                            visited[tempX][tempY] = true;
                            q.add(new int[]{tempX, tempY, temp[2]+1});
                        }
                    }
                }
            }

            if(answer == Integer.MAX_VALUE) sb.append("IMPOSSIBLE").append("\n");
            else sb.append(answer+1).append("\n");
        }
        System.out.println(sb);
    }

    private static boolean isExit(int x, int y) {
        return (x == 0) || (x == h-1) || (y == 0) || (y == w-1);
    }

    private static boolean isValid(int x, int y) {
        return x>=0 && y>=0 && x<h && y<w;
    }
}