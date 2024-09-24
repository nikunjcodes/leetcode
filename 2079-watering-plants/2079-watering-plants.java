public class Solution{
public int wateringPlants(int[] p, int capacity) {
    int ans = 0;
    int curr =0;
    for (int i = 0; i < p.length; ++i) {
        if (curr< p[i]) {
            ans += i * 2;
            curr= capacity;
        }
        curr -= p[i];
    }
    return ans + p.length;        
}
}