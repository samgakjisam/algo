#include<iostream>
#include<stack>

using namespace std;

int k;
int S[13] = { 0, };
int vis[13] = { 0, };

bool flg = true;

void comb(int x, int r) {
	if (r == 6) {
		for (int i = 0; i < k; i++) {
			if (vis[i] == 1) {
				cout << S[i] << " ";
			}
		}
		cout << endl;
		return;
	}
	else if (k - x + r < 6)
		return;
	else if (x >= 13)
		return;

	vis[x] = 1;
	comb(x + 1, r + 1);
	vis[x] = 0;
	comb(x + 1, r);
}

void t_case() {
	cin >> k;
	if (k == 0) {
		flg = false;
		return;
	}

	for (int i = 0; i < k; i++)
		cin >> S[i];

	comb(0, 0);
}

int main() {
	ios::sync_with_stdio(false);
	cin.tie(0);

	while (flg) {
		t_case();
		cout << endl;
	}

	return 0;
}
