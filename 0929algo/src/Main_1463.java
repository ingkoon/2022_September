import java.util.Arrays;
import java.util.Scanner;

public class Main_1463 {
    static int n;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        int[] dp = new int[n+1];
        int INF = 1000001;
        dp[1] = 0;
        
        for(int i = 1; i <=n; i++){
            int min = INF;
            min = Math.min(min, dp[i-1]+1);
            if(i % 3 == 0) min = Math.min(min, dp[i/3] + 1);
            if(i % 2 == 0) min = Math.min(min, dp[i/2] + 1);

            dp[i] = min;
        }
        System.out.println(dp[n]-1);
    }
}
