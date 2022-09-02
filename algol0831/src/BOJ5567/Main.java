package BOJ5567;

import java.util.*;

public class Main {
    static int n;
    static int len;
    static boolean[] visited;
    static int result;
    static List<ArrayList<Guest>> arr;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        len = sc.nextInt();
        visited = new boolean[n+1];
        arr = new ArrayList<>();

        for (int i = 0; i < n+1; i++) {
            arr.add(new ArrayList<>());
        }

        for (int i = 0; i < len; i++) {
            int from = sc.nextInt();
            int to = sc.nextInt();
            arr.get(from).add(new Guest(to));
            arr.get(to).add(new Guest(from));
        }

        bfs(1);
        System.out.println(result);
    }

    private static void bfs(int cnt){
        Queue<List<Guest>> queue = new LinkedList<>();
        queue.offer(arr.get(cnt));
        visited[cnt] = true;
        while(!queue.isEmpty()){
            List<Guest> tmp = queue.poll();
            System.out.println(Arrays.toString(tmp.toArray()));
            for (Guest t : tmp) {
                if(visited[t.num] || t.depth > 2) continue;
                result++;
                visited[t.num] = true;
                t.depth++;
                queue.offer(arr.get(t.num));
            }
        }
    }

    static class Guest{
        int num;
        int depth;
        public Guest(int num){
            this.num = num;
        }
    }
}