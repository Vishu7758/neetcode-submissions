class Solution {
public:
    int missingNumber(vector<int>& nums) {
        int mask=0;
        for(int i=0; i<=nums.size(); i++) mask^=i;
        for(auto &num : nums) mask^=num;
        return mask;
    }
};
