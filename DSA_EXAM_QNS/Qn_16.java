package DSA_EXAM_QNS;

public class Qn_16 {
    public class LCS {

        // Method to compute the length of the longest common subsequence
        public static int lcs(String s1, String s2) {
            int m = s1.length();
            int n = s2.length();
            
            // dp[i][j] holds the LCS length for s1[0..i-1] and s2[0..j-1]
            int[][] dp = new int[m + 1][n + 1];
            
            // Build the dp array from the bottom up
            for (int i = 1; i <= m; i++) {
                for (int j = 1; j <= n; j++) {
                    if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                        dp[i][j] = dp[i - 1][j - 1] + 1;
                    } else {
                        dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                    }
                }
            }
            
            return dp[m][n];
        }
        
        public static void main(String[] args) {
            String s1 = "company";
            String s2 = "colony";
            int lcsLength = lcs(s1, s2);
            System.out.println("Length of maximum common subsequence: " + lcsLength);
        }
    }
    
}
