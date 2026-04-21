class Solution {
public:
    vector<vector<int>> pacificAtlantic(vector<vector<int>>& heights) {
        int m=heights.size(), n=heights[0].size();
        vector<vector<pair<int, int>>> top(m, vector<pair<int,int>>(n, {0,0}));
        vector<vector<pair<int, int>>> bottom(m, vector<pair<int,int>>(n, {0,0}));
        vector<vector<pair<int, int>>> result(m, vector<pair<int,int>>(n, {0,0}));
        vector<vector<int>> ans;
        // top right
        top[0][n-1] = {1,1};
        for(int i=1; i<m; i++) {
            top[i][n-1].second++;
            if(heights[i][n-1]>=heights[i-1][n-1]) top[i][n-1].first = top[i-1][n-1].first;
        }
        for(int i=n-2; i>=0; i--) {
            top[0][i].first++;
            if(heights[0][i]>=heights[0][i+1]) top[0][i].second = top[0][i+1].second;
        }
        for(int row=1; row<m; row++) {
            for(int col=n-2; col>=0; col--) {
                if(heights[row][col]>=heights[row-1][col]) {
                    top[row][col] = make_pair(max(top[row][col].first, top[row-1][col].first),
                                        max(top[row][col].second, top[row-1][col].second));
                }
                if(heights[row][col]>=heights[row][col+1]) {
                    top[row][col] = make_pair(max(top[row][col].first, top[row][col+1].first),
                                        max(top[row][col].second, top[row][col+1].second));
                }
            }
        }
        // bottom left
        bottom = top;
        bottom[m-1][0] = {1,1};
        for(int i=m-2; i>=0; i--) {
            bottom[i][0].first++;
            if(heights[i][0]>=heights[i+1][0]) bottom[i][0].second = bottom[i+1][0].second;
        }
        for(int i=1; i<n; i++) {
            bottom[m-1][i].second++;
            if(heights[m-1][i]>=heights[m-1][i-1]) bottom[m-1][i].first = bottom[m-1][i-1].first;
        }
        for(int row=m-2; row>=0; row--) {
            for(int col=1; col<n; col++) {
                if(heights[row][col]>=heights[row][col-1]) {
                    bottom[row][col]={max(bottom[row][col].first,bottom[row][col-1].first),
                                      max(bottom[row][col].second,bottom[row][col-1].second)}; 
                }
                if(heights[row][col]>=heights[row+1][col]) {
                    bottom[row][col]={max(bottom[row][col].first,bottom[row+1][col].first),
                                      max(bottom[row][col].second,bottom[row+1][col].second)}; 
                }
            }
        }
        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                result[i][j] = {max(top[i][j].first,bottom[i][j].first),
                                max(top[i][j].second,bottom[i][j].second)};
                if(result[i][j].first>0 and result[i][j].second>0) ans.push_back({i,j});
            }
        }
        // cout<<"Input\n";
        // for(auto i : heights) {
        //     for(auto x : i) {
        //         cout<<x<<" ";
        //     }
        //     cout<<endl;
        // }
        // cout<<"Top\n";
        // for(auto i : top) {
        //     for(auto x : i) {
        //         cout<<"{"<<x.first<<","<<x.second<<"} ";
        //     }
        //     cout<<endl;
        // }
        // cout<<"Bottom\n";
        // for(auto i : bottom) {
        //     for(auto x : i) {
        //         cout<<"{"<<x.first<<","<<x.second<<"} ";
        //     }
        //     cout<<endl;
        // }
        // cout<<"Result\n";
        // for(auto i : result) {
        //     for(auto x : i) {
        //         cout<<"{"<<x.first<<","<<x.second<<"} ";
        //     }
        //     cout<<endl;
        // }
        return ans;
    }
};
