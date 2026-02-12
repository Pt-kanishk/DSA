class Solution {
    public int longestBalanced(String s) {
        int n = s.length();
        int ans = 0;
        for (int i = 0; i < n; i++) {
            int[] freq = new int[26];
            int max = 0;
            for (int j = i; j < n; j++) {
                int idx = s.charAt(j) - 'a';
                freq[idx]++;
                max = Math.max(max, freq[idx]);
                int cnt = 0;
                boolean ok = true;
                for (int k = 0; k < 26; k++) {
                    if (freq[k] > 0) {
                        cnt++;
                        if (freq[k] != max) {
                            ok = false;
                            break;
                        }
                    }
                }
                if (ok) {
                    ans = Math.max(ans, cnt * max);
                }
            }
        }
        return ans;
    }
}
