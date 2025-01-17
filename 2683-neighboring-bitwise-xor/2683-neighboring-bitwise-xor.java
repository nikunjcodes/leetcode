class Solution {
    public boolean doesValidArrayExist(int[] derived) {
        int xor=0;
        for(int num : derived)
            xor = xor^num;
        return xor==0;
    }
} 