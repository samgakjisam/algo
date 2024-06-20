#include<iostream>

using namespace std;

int t, n, m, x, y;

int lcm(int a, int b) {
	int na, nb, c;
	na = a;
	nb = b;
	while (nb != 0) {
		c = na % nb;
		na = nb;
		nb = c;
	}

	return a * b / na;
}

void func() {
	cin >> m >> n >> x >> y;
	int mul = 0;
	int a = x;
	int ma = lcm(n, m);

	while (a <= ma) {
		if (a % n == y || (n == y && a % n == 0)) {
			cout << a << "\n";
			return;
		}
		mul++;
		a = mul * m + x;
	}
	cout << -1 << "\n";
	return;
}

int main() {
	ios::sync_with_stdio(false);
	cin.tie(0);

	cin >> t;
	
	for (int i = 0; i < t; i++) {
		func();
	}

	return 0;
}
