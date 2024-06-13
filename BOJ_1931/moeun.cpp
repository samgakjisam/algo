#include<iostream>
#include<algorithm>

using namespace std;

int n;
pair<int, int> ocu[100000];
int ans = 0;

void check() {

}

int main() {
	ios::sync_with_stdio(false);
	cin.tie(0);

	cin >> n;

    for (int i = 0; i < n; i++) {
        int st, ed;
        cin >> st >> ed;
        ocu[i] = { ed, st };
    }
    sort(ocu, ocu + n);

    int now = -1;

    for (int i = 0; i < n; i++) {
        if (ocu[i].second >= now) {
            ans++;
            now = ocu[i].first;
        }
    }

	cout << ans;

	return 0;
}
