class Solution {
public:
    bool containsDuplicate(vector<int>& nums) {
        map<int,int>m;
        for(int i : nums)
            m[i]++;
        for(auto e: m){
            if(e.second>=2)
                return true;
        }
        return false;
    }
};