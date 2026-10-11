import java.util.*;

class Solution {
    private static final long MOD = 1_000_000_007L;

    public int[] queryConversions(int[][] conversions, int[][] queries) {
        int n = conversions.length + 1;
        List<long[]>[] adj = new ArrayList[n];
        for (int i = 0; i < n; i++) adj[i] = new ArrayList<>();
        for (int[] c : conversions) {
            adj[c[0]].add(new long[]{c[1], c[2]});                  // 1 a = f b
            adj[c[1]].add(new long[]{c[0], pow(c[2], MOD - 2)});   // 1 b = f⁻¹ a
        }

        long[] base = new long[n];      // base[u] = units of u per 1 unit of 0
        boolean[] seen = new boolean[n];
        Deque<Integer> q = new ArrayDeque<>();
        base[0] = 1;
        seen[0] = true;
        q.offer(0);
        while (!q.isEmpty()) {
            int u = q.poll();
            for (long[] e : adj[u]) {
                int v = (int) e[0];
                if (seen[v]) continue;
                seen[v] = true;
                base[v] = base[u] * e[1] % MOD;
                q.offer(v);
            }
        }

        int[] ans = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int a = queries[i][0], b = queries[i][1];
            ans[i] = (int) (base[b] * pow(base[a], MOD - 2) % MOD);
        }
        return ans;
    }

    private long pow(long b, long e) {
        long r = 1;
        b %= MOD;
        while (e > 0) {
            if ((e & 1) == 1) r = r * b % MOD;
            b = b * b % MOD;
            e >>= 1;
        }
        return r;
    }
}