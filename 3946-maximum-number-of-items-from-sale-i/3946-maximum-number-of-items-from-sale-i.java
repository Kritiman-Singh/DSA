class Solution {
    public int maximumSaleItems(int[][] items, int budget) {
        int n = items.length;
        int mn = Integer.MAX_VALUE;
        for (int[] it : items) mn = Math.min(mn, it[1]);

        int[] f = new int[budget + 1];

        for (int[] it : items) {
            int factor = it[0], price = it[1];
            int gain = 0;
            for (int[] other : items) {
                if (other[0] % factor == 0) gain++;
            }
            for (int b = budget; b >= price; b--) {
                f[b] = Math.max(f[b], f[b - price] + gain);
            }
        }

        int ans = 0;
        for (int b = 0; b <= budget; b++) {
            ans = Math.max(ans, f[b] + (budget - b) / mn);
        }
        return ans;
    }
}