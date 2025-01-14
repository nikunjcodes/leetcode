class Solution {
    public int[] findThePrefixCommonArray(int[] A, int[] B) {
        int l = A.length;
        int[] freq = new int[l + 1];
        int[] ans = new int[l];
        int temp = 0;

        for (int i = 0; i < l; i++) {
            if(freq[A[i]]==1)
                temp++;
            else
                freq[A[i]]=1;
            if(freq[B[i]]==1)
                temp++;
            else
                freq[B[i]]=1;
            ans[i] = temp;
        }
        return ans;
    }
}
