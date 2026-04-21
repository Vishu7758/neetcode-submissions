class Solution {
public:
    void dfs1(vector<vector<char>>& board, int i, int j) {
        int m = board.size(), n = board[0].size();
        if(i<0 or i>=m or j<0 or j>=n or board[i][j]=='1' or board[i][j]=='X') return;
        board[i][j] = '1';
        int a[] = {-1,1,0,0,};
        int b[] = {0,0,-1,1};
        for(int idx=0; idx<4; idx++) {
            dfs1(board, i+a[idx], j+b[idx]);
        }
    }
    void dfs2(vector<vector<char>>& board, int i, int j) {
        int m = board.size(), n = board[0].size();
        if(i<0 or i>=m or j<0 or j>=n or board[i][j]=='X' or board[i][j]=='1') return;
        board[i][j] = 'X';
        int a[4] = {-1,1,0,0};
        int b[4] = {0,0,-1,1};
        for(int idx=0; idx<4; idx++) {
            dfs2(board, i+a[idx], j+b[idx]);
        }
    }
    void solve(vector<vector<char>>& board) {
        int m = board.size(), n = board[0].size();
        // for(auto x : board) {
        //     for(auto y : x) cout<<y<<' ';
        //     cout<<endl;
        // }
        // cout<<"After row\n";
        for(int i=0; i<m; i++) {
            if(board[i][0]=='O') dfs1(board, i, 0);
            if(board[i][n-1]=='O') dfs1(board, i, n-1);
        }
        // for(auto x : board) {
        //     for(auto y : x) cout<<y<<' ';
        //     cout<<endl;
        // }
        for(int i=0; i<n; i++) {
            if(board[0][i]=='O') dfs1(board, 0, i);
            if(board[m-1][i]=='O') dfs1(board, m-1, i);
        }
        // cout<<"After col\n";
        // for(auto x : board) {
        //     for(auto y : x) cout<<y<<' ';
        //     cout<<endl;
        // }
        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                if(board[i][j]=='O') dfs2(board, i, j);
            }
        }
        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                if(board[i][j]=='1') board[i][j] = 'O';
            }
        }
    }
};
