class Solution {
    public int[] zFunction(String input) {
        int length = input.length();
        int[] zArray = new int[length];
        int left = 0, right = 0;

        for (int i = 1; i < length; i++) {
            if (i < right) {
                zArray[i] = Math.min(right - i, zArray[i - left]);
            }
            while (i + zArray[i] < length && input.charAt(zArray[i]) == input.charAt(i + zArray[i])) {
                zArray[i]++;
            }
            if (i + zArray[i] > right) {
                left = i;
                right = i + zArray[i];
            }
        }
        return zArray;
    }

    public int minStartingIndex(String text, String pattern) {
        String concatenatedString = pattern + "#" + text;
        int textLength = text.length();
        int patternLength = pattern.length();
        String reversedString = text + "#" + pattern;
        StringBuilder reversedBuilder = new StringBuilder(reversedString).reverse();
        
        int[] zForward = zFunction(concatenatedString);
        int[] zBackward = zFunction(reversedBuilder.toString());
    
        for (int i = patternLength + 1; i < textLength + patternLength + 1; i++) {
            if (i + patternLength > textLength + patternLength + 1) {
                break;
            }

            int currentIndex = i - patternLength - 1;
            int matchedLength = zForward[i];
            if (matchedLength >= patternLength - 1) {
                return currentIndex;
            }
            matchedLength++;

            int requiredLength = patternLength - matchedLength;
            int newId = currentIndex + patternLength - 1;
            newId = textLength - 1 - newId;
            newId = patternLength + 1 + newId;
            if (zBackward[newId] >= requiredLength) {
                return currentIndex;    
            }   
        }
        return -1;
    }
}