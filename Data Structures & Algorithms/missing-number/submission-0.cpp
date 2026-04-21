class Solution {
public:
    int missingNumber(vector<int>& nums) {
        int mask1=0, mask2=0;
        for(int i=0; i<=nums.size(); i++) mask1^=i;
        for(auto &num : nums) mask2^=num;
        return mask1^mask2;
    }
};
