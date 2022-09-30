package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_1600 {
    static int k;
    static int r, c;
    static int result;
    static int[][] map;
    static boolean[][][] visited;

    static int[] horseR = {2, 2, 1, -1, -2, -2, 1, -1};
    static int[] horseC = {1, -1, 2, 2, 1, -1, -2, -2};
    static int[] dr = {1, 0, -1, 0};
    static int[] dc = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        k = Integer.parseInt(bf.readLine());
        StringTokenizer st = new StringTokenizer(bf.readLine());
        c = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());

        result = Integer.MAX_VALUE;
        map = new int[r][c];
        visited = new boolean[k+1][r][c];
        for (int i = 0; i < r; i++) {
            st = new StringTokenizer(bf.
                    readLine());
            for (int j = 0; j < c; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        bfs(0, 0, k);
        System.out.println(result == Integer.MAX_VALUE? -1 : result);
    }

    public static void bfs(int sr, int sc, int k){
        Queue<Loc> queue = new LinkedList<>();
        queue.offer(new Loc(sr, sc, k, 0));
        visited[k][sr][sc] = true;

        while(!queue.isEmpty()){
            Loc loc = queue.poll();
            int pr = loc.r;
            int pc = loc.c;
            int pHorse = loc.horse;
            int pCnt = loc.count;

            if(pr == r - 1 && pc == c - 1){
                result = Math.min(result, pCnt);
                continue;
            }

            if(pHorse > 0){
                for (int i = 0; i < 8; i++) {
                    int nr = pr + horseR[i];
                    int nc = pc + horseC[i];
                    if(isCheck(nr, nc) && !visited[pHorse-1][nr][nc] && map[nr][nc] != 1){
                        visited[pHorse-1][nr][nc] = true;
                        queue.offer(new Loc(nr, nc, pHorse-1, pCnt+1));
                    }
                }
            }
            for (int i = 0; i < 4; i++) {
                int nr = pr + dr[i];
                int nc = pc + dc[i];
                if(isCheck(nr, nc) && !visited[pHorse][nr][nc]  && map[nr][nc] != 1){
                    visited[pHorse][nr][nc] = true;
                    queue.offer(new Loc(nr, nc, pHorse, pCnt+1));
                }
            }
        }
    }
    public static boolean isCheck(int nr, int nc){
        return 0 <= nr && nr < r && 0 <= nc && nc < c;
    }
    public static class Loc{
        int r;
        int c;
        int horse;
        int count;

        public Loc(int r, int c, int horse, int count) {
            this.r = r;
            this.c = c;
            this.horse = horse;
            this.count = count;

        }
    }
}
