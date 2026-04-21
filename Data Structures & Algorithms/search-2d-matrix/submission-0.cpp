class Solution {
public:
    bool searchMatrix(vector<vector<int>>& matrix, int target) {
        int m=matrix.size(), n=matrix[0].size();
        vector<int> r;
        for(auto i : matrix) r.push_back(i[0]);
        auto x = lower_bound(r.begin(), r.end(), target);
        if(x==r.end()) {
            // cout<<"Inside if : "<<(x-r.begin())<<" "<<matrix[m-1][n-1]<<" "<<target<<endl;
            if(matrix[m-1][n-1]<target) return false;
            auto it = lower_bound(matrix[m-1].begin(), matrix[m-1].end(), target);
            return it!=matrix[m-1].end() and *it==target;
        }
        if(x==r.begin()) return *x==target;
        if(*x==target) return true;
        int idx = x-r.begin()-1;
        // if(*x>target) idx--;
        // cout<<"Outside if : "<<*x<<' '<<idx<<endl;
        auto it = lower_bound(matrix[idx].begin(), matrix[idx].end(), target);
        return it!=matrix[idx].end() and *it==target;
    }
};
