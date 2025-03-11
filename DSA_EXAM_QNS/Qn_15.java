package DSA_EXAM_QNS;

public class Qn_15 {
    public class EditDistance {
        public static void main(String[] args) {
            String s1 = "ARTIFICIAL";
            String s2 = "NATURAL";
            int m = s1.length();
            int n = s2.length();
            
            int[][] dp = new int[m + 1][n + 1];
            
            for (int i = 0; i <= m; i++) {
                dp[i][0] = i;
            }
            for (int j = 0; j <= n; j++) {
                dp[0][j] = j;
            }
            for (int i = 1; i <= m; i++) {
                for (int j = 1; j <= n; j++) {
                    int cost = (s1.charAt(i - 1) == s2.charAt(j - 1)) ? 0 : 1;
                    dp[i][j] = Math.min(dp[i - 1][j] + 1,                   // Deletion
                                Math.min(dp[i][j - 1] + 1,                   // Insertion
                                         dp[i - 1][j - 1] + cost));           // Substitution
                }
            }
            System.out.println("Edit distance: " + dp[m][n]);
        }
    }
}