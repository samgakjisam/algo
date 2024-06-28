#include<iostream>


using namespace std;
int n, m, ans;
int boa[4][4] = {0,};
int vis[4][4] = {0,};

int dx[4] = {1, 0, -1, 0};
int dy[4] = {0, 1, 0, -1};

void dfs(int x, int y, int r) {
    // cout << x << " " << y << "\n";    
    if (boa[x][y] == m) {
        ans++;
        // cout << "arived " << ans << "\n";
        return;
    }

    for (int i = 0; i < 4; i++) {
        int nx = x + dx[i];
        int ny = y + dy[i];

        if (
            nx >= 0 && nx < n &&
            ny >= 0 && ny < n &&
            boa[nx][ny] != 1 &&
            vis[nx][ny] != 1 &&
            boa[nx][ny] <= r
            ) 
        {
            vis[nx][ny] = 1;
            if (boa[nx][ny] == r) {
                dfs(nx, ny, r + 1);
            }
            else {
                dfs(nx, ny, r);
            }
            vis[nx][ny] = 0;                
        }
    }
}

int main(int argc, char** argv)
{
    cin >> n >> m;
    ans = 0;

    for (int i = 0; i < n; i++) {
        for (int j = 0; j < n; j++) {
            cin >> boa[i][j];
        }
    }

    int mok = 1;
    int x, y;
    for (int i = 0; i < m; i++) {
        int a, b;
        cin >> a >> b;

        if (mok == 1) {
            x = a - 1;
            y = b - 1;
        }
        boa[a - 1][b - 1] = mok;
        mok++;
    }

    vis[x][y] = 1;
    dfs(x, y, 2);

    cout << ans;
    
   return 0;
}
