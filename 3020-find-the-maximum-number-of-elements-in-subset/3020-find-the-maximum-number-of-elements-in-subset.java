class Solution {
    public int maximumLength(int[] nums) {

        HashMap<Long, Integer> map = new HashMap<>();

        for (int x : nums) {
            map.put((long) x, map.getOrDefault((long) x, 0) + 1);
        }

        int ans = 1;

        // Handle 1 separately
        if (map.containsKey(1L)) {
            int cnt = map.get(1L);
            if ((cnt & 1) == 0) cnt--;
            ans = Math.max(ans, cnt);
        }

        for (long start : map.keySet()) {

            if (start == 1) continue;

            long cur = start;
            int len = 0;

            while (true) {

                int cnt = map.getOrDefault(cur, 0);
if (cnt >= 2) {

    if (cur > 1000000000L / cur ||
        !map.containsKey(cur * cur)) {

        len++;
        break;
    }

    len += 2;
    cur *= cur;
}else if (cnt == 1) {
                    len++;
                    break;
                } else {
                    if (len >= 2) len -= 2;
                    break;
                }
            }

            ans = Math.max(ans, len);
        }

        return ans;
    }
}