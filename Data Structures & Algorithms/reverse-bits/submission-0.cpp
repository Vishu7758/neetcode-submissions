class Solution {
public:
    uint32_t reverseBits(uint32_t n) {
        uint32_t ans=0, mask1=1, mask2=1<<31;
        for(int i=0; i<32; i++) {
            if(mask1&n) {
                ans |= mask2;
            }
            mask1<<=1;
            mask2>>=1;
        }
        return ans;
    }
};
