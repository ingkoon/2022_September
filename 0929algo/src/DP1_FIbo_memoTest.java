import java.util.Arrays;
import java.util.Scanner;

public class DP1_FIbo_memoTest {
    static long[] calls1, calls2;
    static long callCnt1, callCnt2;
    static int n;

    static long[] memo;

    static long fibo1(int n){
        callCnt1++;
        calls1[n]++;
        if(n <= 1) return n; // 1항이면 1, 0항이면 0
        return fibo1(n-1) + fibo1(n-2);
    }

    static long fibo2(int n){
        callCnt2++;
        calls2[n]++;

        if(memo[n] == -1){ // 메모 안되어있음
            memo[n] = fibo2(n-1) + fibo2(n-2); // 계산 후 메모
        }
        return memo[n]; // 메모 된 값 리턴
    }

    public static void main(String[] args) {
      Scanner sc = new Scanner(System.in);
      n = sc.nextInt();

      calls1 = new long[n+1]; // 각 항을 계산하기 위한 수행 횟수
      calls2 = new long[n+1];

      callCnt1 = callCnt2= 0; // 총 수행 횟수

      memo = new long[n+1];
      Arrays.fill(memo, -1); // 메모되지 않는 상태를 나타내는 값으로 초기화
        // 처음부터 계산이 간으한 값 초기화
        memo[0] = 0;
        memo[1] = 1;

        System.out.println(fibo1(n));
        System.out.println(callCnt1);
        for (int i = 0; i < n; i++) {
            System.out.println("fibo1(" + i + ") :" + calls1[i]);
        }
        System.out.println("---------------------------");

        System.out.println(fibo2(n));
        System.out.println(callCnt2);
        for (int i = 0; i < n; i++) {
            System.out.println("fibo2(" + i + ") :" + calls2[i]);
        }
        System.out.println("---------------------------");
    }
}
