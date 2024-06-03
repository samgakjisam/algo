#include<iostream>

using namespace std;

int n, white, blue;
int boa[128][128];

int nap(int x, int y, int a, int b) {
	if (x == a) {
		//cout << boa[x][y] << "\n";
		return boa[x][y];
	}
	//cout << x << " " << a << " " << y << " " << b << "\n";

	int lt, rt, lb, rb;

	lt = nap(x, y, (x + a) / 2, (y + b) / 2);
	rt = nap((x + a) / 2 + 1, y, a, (y + b) / 2);
	lb = nap(x, (y + b) / 2 + 1, (x + a) / 2, b);
	rb = nap((x + a) / 2 + 1, (y + b) / 2 + 1, a, b);

	if (lt == rt && rt == lb && lb == rb) {
		if (lt == 1)
			return 1;
		else if (lt == 0)
			return 0;
		else
			return 2;
	}
	else {
		if (lt == 1)
			blue++;
		else if (lt == 0)
			white++;

		if (rt == 1)
			blue++;
		else if (rt == 0)
			white++;

		if (lb == 1)
			blue++;
		else if (lb == 0)
			white++;

		if (rb == 1)
			blue++;
		else if (rb == 0)
			white++;

		return 2;
	}
}

int main() {
	ios::sync_with_stdio(false);
	cin.tie(0);
	
	cin >> n;
	white = blue = 0;

	for (int i = 0; i < n; i++) {
		for (int j = 0; j < n; j++) {
			cin >> boa[i][j];
		}
	}

	int p;

	p = nap(0, 0, n - 1, n - 1);

	if (p == 1)
		blue++;
	else if (p == 0)
		white++;
	
	cout << white << "\n" << blue;

	return 0;
}
