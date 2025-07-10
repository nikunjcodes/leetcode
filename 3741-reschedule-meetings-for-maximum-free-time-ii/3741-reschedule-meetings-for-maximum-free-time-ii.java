class Solution {
    public int maxFreeTime(int total, int[] a, int[] b) {
      int n = a.length;
        int[] gap = new int[n + 1];
        gap[0] = a[0];
        for (int i = 1; i < n; i++) {
            gap[i] = a[i] - b[i - 1];
        }
        gap[n] = total - b[n - 1];
        int[] maxiLeft = new int[n + 1];
        int[] maxiRight = new int[n + 1];
        int max = -1;
        for (int i = 0; i <= n; i++) {
            max = Math.max(max, gap[i]);
            maxiLeft[i] = max;
        }
        max = -1;
        for (int i = n; i >= 0; i--) {
            max = Math.max(max, gap[i]);
            maxiRight[i] = max;
        }
        int answer = 0;
        for (int i = 0; i < n; i++) {
            int curr = gap[i] + (b[i] - a[i]) + gap[i + 1];
            int target = b[i] - a[i];
            answer = Math.max(answer, curr - target);
            if ((i > 0 && maxiLeft[i - 1] >= target) || (i + 2 <= n && maxiRight[i + 2] >= target)) {
                answer = Math.max(answer, curr);
            }
        }
        return answer;
        
    }
}