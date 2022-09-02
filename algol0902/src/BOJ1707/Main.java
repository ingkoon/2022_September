package BOJ1707;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
    static int k, v, e;
    static int[] visited;

    static boolean result;
    static List<List<Integer>> graph;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        k = sc.nextInt();

        for (int t = 0; t < k; t++) {

            v = sc.nextInt();
            e = sc.nextInt();
            visited = new int[v+1];
            graph = new ArrayList<>();
            result = true;
            //graph 초기화
            Arrays.fill(visited, -1);

            // ArrayList 초기화
            for (int i = 0; i < v+1; i++) {
                graph.add(new ArrayList<>());
            }

            for (int i = 0; i < e; i++) {
                int from = sc.nextInt();
                int to = sc.nextInt();
                graph.get(from).add(to);
                graph.get(to).add(from);
            }
//            visited[0] = 0;

            visited[1] = 1;
            dfs(1, 0);
            System.out.println(result ? "YES" : "NO");
        }
    }


    public static void dfs(int cnt, int flagVal){
        // 이전 레벨과 같은 값일 경우 이분 그래프가 아니다
        if(visited[cnt] == flagVal) {
            System.out.println(cnt + " : " + flagVal);
            result = false;
            return;
        }

        // 해당 레벨의 값을 가져온다.
        List<Integer> tmp = graph.get(cnt);
        for (Integer t : tmp) {
            //-1이 아닐 경우
            if(visited[t] != -1) {
                if(visited[t] == flagVal){
                    result = false;
                }
                continue;
            }
            // -1일 경우
            else{
                //flag에 -1한값의 절대값을 대입
                visited[t] = Math.abs(flagVal);
                dfs(t, Math.abs(flagVal-1));
            }
        }
    }
}
