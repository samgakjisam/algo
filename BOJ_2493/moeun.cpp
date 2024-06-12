#include<iostream>

using namespace std;

int n;
int st[500000][2];
int t = -1;

void check(int a, int i) {
	while (t >= 0) {
		if (st[t][0] < a) {
			st[t][0] = 0;
			t--;
		}
		else {
			cout << st[t][1] << " ";
			t++;
			st[t][0] = a;
			st[t][1] = i;
			return;
		}
	}
	cout << 0 << " ";
	t++;
	st[t][0] = a;
	st[t][1] = i;
}

int main() {
	ios::sync_with_stdio(false);
	cin.tie(0);

	cin >> n;


	for (int i = 1; i <= n; i++) {
		int a;
		cin >> a;

		check(a, i);

		//for (int j = 0; j < n; j++) {
		//	cout << st[j][0] << " ";
		//}
		//cout << "\n";
	}

	

	return 0;
}
