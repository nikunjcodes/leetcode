class Solution {
    public boolean rotateString(String s, String goal) {
        String temp = s+s;
        return s.length() == goal.length() && temp.contains(goal);
    }
}