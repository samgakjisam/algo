#include<iostream>
#include<string>

using namespace std;

int n, m;
string li;

int main() {
	ios::sync_with_stdio(false);
	cin.tie(0);

	cin >> n >> m >> li;
	
	int flg = 0;
	int seq = 0;
	int ans = 0;

	for (int i = 0; i < li.length(); i++) {
		char c = li[i];

		if (flg == 0 && c == 'I') {
			flg = 1;
		}
		else if (flg == 1) {
			if (c == 'O') {
				flg = 2;
			}
			else {
				seq = 0;
			}
		}
		else if (flg == 2) {
			if (c == 'O') {		
				flg = 0;
				seq = 0;
			}
			else {
				flg = 1;
				seq++;
				if (seq >= n) {
					ans++;
				}
			}
		}
	}

	cout << ans;

	return 0;
}
