import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_1149 {
    static int n;
    static int[][] houses;
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(bf.readLine());
        houses = new int[n][3];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(bf.readLine());
            for (int j = 0; j < 3; j++) {
                houses[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 1; i < n; i++) {
            houses[i][0] += Math.min(houses[i-1][1], houses[i-1][2]);
            houses[i][1] += Math.min(houses[i-1][0], houses[i-1][2]);
            houses[i][2] += Math.min(houses[i-1][0], houses[i-1][1]);
        }

        Integer result = Arrays.stream(houses[n-1]).min().getAsInt();
        System.out.println(result);

    }
}
