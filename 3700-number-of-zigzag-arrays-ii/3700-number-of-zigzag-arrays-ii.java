class Solution {

    static final long MOD = 1_000_000_007L;

    private long[][] multiply(long[][] a, long[][] b) {
        int n = a.length;

        long[][] res = new long[n][n];

        for (int i = 0; i < n; i++) {
            for (int k = 0; k < n; k++) {

                if (a[i][k] == 0) continue;

                long val = a[i][k];

                for (int j = 0; j < n; j++) {
                    if (b[k][j] == 0) continue;

                    res[i][j] =
                        (res[i][j] + val * b[k][j]) % MOD;
                }
            }
        }

        return res;
    }

    private long[][] power(long[][] base, long exp) {

        int n = base.length;

        long[][] res = new long[n][n];

        for (int i = 0; i < n; i++) {
            res[i][i] = 1;
        }

        while (exp > 0) {

            if ((exp & 1) == 1) {
                res = multiply(res, base);
            }

            base = multiply(base, base);
            exp >>= 1;
        }

        return res;
    }

    public int zigZagArrays(int n, int l, int r) {

        int m = r - l + 1;

        int size = 2 * m;

        long[][] T = new long[size][size];

        // DOWN(x) -> UP(y), y < x
        for (int x = 0; x < m; x++) {
            for (int y = 0; y < x; y++) {
                T[m + y][x] = 1;
            }
        }

        // UP(x) -> DOWN(y), y > x
        for (int x = 0; x < m; x++) {
            for (int y = x + 1; y < m; y++) {
                T[y][m + x] = 1;
            }
        }

        long[][] P = power(T, n - 1);

        long[] start = new long[size];

        for (int i = 0; i < size; i++) {
            start[i] = 1;
        }

        long ans = 0;

        for (int i = 0; i < size; i++) {
            long cur = 0;

            for (int j = 0; j < size; j++) {
                cur = (cur + P[i][j] * start[j]) % MOD;
            }

            ans = (ans + cur) % MOD;
        }

        return (int) ans;
    }
}