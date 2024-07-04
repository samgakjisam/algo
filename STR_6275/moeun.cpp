#include<iostream>
#include<string>

using namespace std;

int n, m;
string boa[25];
int dx[4] = {0, 1, 0, -1};
int dy[4] = {1, 0, -1, 0};

void r_start(int x, int y, int d) {

    while (true) {
        int nx = x + dx[d];
        int ny = y + dy[d];
    
        if (nx < n && nx >= 0 && ny < m && ny >= 0 && boa[nx][ny] == '#') {
            cout << 'A';
            x = nx + dx[d];
            y = ny + dy[d];
            continue;
        }
        
        int rd = (d + 1) % 4;
        int rx = x + dx[rd];
        int ry = y + dy[rd];
        
        if (rx < n && rx >= 0 && ry < m && ry >= 0 && boa[rx][ry] == '#') {
            cout << 'R';
            d = rd;
            continue;
        }

        int ld = (d + 3) % 4;
        int lx = x + dx[ld];
        int ly = y + dy[ld];

        if (lx < n && lx >= 0 && ly < m && ly >= 0 && boa[lx][ly] == '#') {
            cout << 'L';
            d = ld;
        }
        else {
            break;
        }
    }
}

int main(int argc, char** argv)
{
    cin >> n >> m;

    for (int i = 0; i < n; i++) {
        string li;
        cin >> li;
        boa[i] = li;
    }

    int x = -1;
    int y = -1;
    int dr = -1;

    for (int i = 0; i < n; i++) {        
        for(int j = 0; j < m; j++) {
            if (boa[i][j] == '.') {
                continue;
            }
            
            int near = 0;
            
            for (int k = 0; k < 4; k++) {
                int ni = i + dx[k];
                int nj = j + dy[k];

                if (ni < n && ni >= 0 && nj < m && nj >= 0 && boa[ni][nj] == '#') {
                    near++;
                    dr = k;
                }
            }

            if (near == 1) {
                x = i;
                y = j;
                break;
            }
            else {
                dr = -1;
            }
        }

        if (dr != -1)
            break;
    }

    char dr_c[4] = {'>', 'v', '<', '^'};
    
    cout << x + 1 << " " << y + 1 << "\n";
    cout << dr_c[dr] << "\n";

    r_start(x, y, dr);
    
   return 0;
}
