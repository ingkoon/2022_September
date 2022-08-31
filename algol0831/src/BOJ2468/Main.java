package BOJ2468;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    static int n;
    static int[][] area;
    static int[][] copy;
    static boolean[][] visited;
    static int[] dr = {-1, 0, 1, 0};
    static int[] dc = {0, 1, 0, -1};

    static int result;
    static int max = Integer.MIN_VALUE;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        area = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                area[i][j] = sc.nextInt();
                max = Math.max(max, area[i][j]);
            }
        }

        for (int t = 0; t <= max; t++) {
            copy = new int[n][n];
            visited = new boolean[n][n];
            int tmp = 0;
            for (int i = 0; i < n; i++) {
                for(int j = 0; j < n; j++){
                    copy[i][j] = Math.max(area[i][j] - t, 0);
                }
            }
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (visited[i][j] || copy[i][j]==0) continue;
                    visited[i][j] = true;
                    dfs(i, j);
                    tmp++;
                }
            }
            result = Math.max(result, tmp);
        }
        System.out.println(result);
    }

    private static void dfs(int r, int c) {
        for (int i = 0; i < 4; i++) {
            int nr = r + dr[i];
            int nc = c + dc[i];
            if(!check(nr, nc) || visited[nr][nc] || copy[nr][nc] == 0) continue;
            visited[nr][nc] = true;
            dfs(nr, nc);
        }
    }

    private static boolean check(int r, int c){
        return 0 <= r && r < n && 0<= c && c < n;
    }
}
