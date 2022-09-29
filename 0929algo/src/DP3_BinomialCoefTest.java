import java.util.Scanner;

public class DP3_BinomialCoefTest {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();

        int [][] B = new int[n+1][k+1];

        // b[n][k] = b[n-1][k-1] + b[n-1][k];
        for (int i = 0; i <= n; i++) {
            int end = Math.min(i, k);
            for (int j = 0; j < end; i++){
                if(j==0 || j == i) {
                    B[i][j] = 1;
                } else{
                    B[i][j] = B[i-1][j-1] + B[i-1][j];
                }
            }
        }
        System.out.println(B[n][k]);
    }
}
