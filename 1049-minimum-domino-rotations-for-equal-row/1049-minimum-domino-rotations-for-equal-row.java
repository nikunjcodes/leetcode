class Solution {
 public int minDominoRotations(int[] tops, int[] bottoms) {
    int[] cnta = new int[7], cntb = new int[7], same = new int[7];
    for (int i = 0; i < tops.length; i++) {
        cnta[tops[i]]++;
        cntb[bottoms[i]]++;
        if (tops[i] == bottoms[i]) same[tops[i]]++;
    }
    for (int i = 1; i <= 6; i++) {
        if (cnta[i] + cntb[i] - same[i] == tops.length) {
            return Math.min(cnta[i], cntb[i]) - same[i];
        }
    }
    return -1;
}
}