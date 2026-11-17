class Solution {
    public int minimumChanges(String s, int k) {

        int n = s.length();
        int INF = 1000000;
        int[][] cost = new int[n][n];

        for (int len = 2; len <= n; len++) {
            for (int i = 0; i + len <= n; i++) {
                int j = i + len - 1;
                cost[i][j] = INF;
                for (int d = 1; d < len; d++) {

                    if (len % d != 0) {
                        continue;
                    }

                    int changes = 0;
                    for (int r = 0; r < d; r++) {
                        int left = r;
                        int right = r + ((len - 1 - r) / d) * d;
                        while (left < right) {
                            if (s.charAt(i + left) != s.charAt(i + right)) {
                                changes++;
                            }
                            left += d;
                            right -= d;
                        }
                    }

                    cost[i][j] = Math.min(cost[i][j], changes);
                }
            }
        }

        int[][] dp = new int[n + 1][k + 1];
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= k; j++) {
                dp[i][j] = INF;
            }
        }

        dp[0][0] = 0;

    
        for (int i = 2; i <= n; i++) {

            for (int j = 1; j <= k; j++) {
                for (int start = 2 * (j - 1); start <= i - 2; start++) {

                    dp[i][j] = Math.min(
                        dp[i][j],
                        dp[start][j - 1] + cost[start][i - 1]
                    );
                }
            }
        }

        return dp[n][k];
    }
}