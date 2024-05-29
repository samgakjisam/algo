#include<iostream>
#include<algorithm>
#define SWAP(a, b, t) ((t) = (a), (a)=(b), (b) = (t))

using namespace std;

int n, m;
int lis[100000], lst[100000];

// 제일 무난하다고 생각하는 퀵정렬
// 연습할 겸 블로그보면서 구현
void qksort(int* arr, int s, int e) {
	// 시작점이 끝점보다 크거나 같음 = 정렬끝났다는뜻
	if (s >= e) return;

	int p = arr[s]; // 피벗은 리스트 시작점에 있는수로
	int left = s; // 두번째 수부터 비교시작
	int right = e; // 오른쪽끝부터 비교시작
	int t; // 스왑용 temp

	while (left < right) // 배열 인덱스가 교차하기 전까지만
	{
		while (arr[left] <= p && left < e) { // 피벗보다 작은수는 패스, 큰수만나면 멈춤
			left++;
		}
		while (arr[right] >= p && right > s) { // 피벗보다 큰수는 패스, 작은수 만나면 멈춤
			right--;
		}

		if (left < right) { // left, right가 만나서 교차 됐을경우는 제외
			// 피벗보다 큰데 왼쪽에 있는수
			// 피벗보다 작은데 오른쪽에 있는수 서로 바꿈
			SWAP(arr[left], arr[right], t);
		}
	}
	// 피벗보다 작은수는 전부 왼쪽, 큰수는 전부 오른쪽에 있음
	// 두수가 교차했으니 현재 right(left가 가르키고 있던 수)를 피벗이랑 바꿈
	SWAP(arr[s], arr[right], t);

	//피벗 왼쪽오른쪽 다시 솔팅
	qksort(arr, s, right - 1);
	qksort(arr, right + 1, e);

	return;
}

int bsearch(int* arr, int t, int s, int e) {
	// 못찾고 순서바뀌는 상황
	if (s > e) return 0;

	int mid = (s + e) / 2; // 반띵

	if (arr[mid] == t) // 일치
		return 1;
	else if (t < arr[mid]) // 타겟보다 수가 크면 왼쪽을 찾아야함
		return bsearch(arr, t, s, mid - 1);
	else // 타겟보다 작은경우 오른쪽 탐색
		return bsearch(arr, t, mid + 1, e);
}

int main() {
	cin >> n;

	for (int i = 0; i < n; i++) {
		cin >> lis[i];
	}

	cin >> m;

	for (int i = 0; i < m; i++) {
		cin >> lst[i];
	}

	sort(lis, lis + n);

	//qksort(lis, 0, n - 1);

	//for (int i = 0; i < n; i++) {
	//	cout << lis[i] << " ";
	//}

	for (int i = 0; i < m; i++) {
		int ans = bsearch(lis, lst[i], 0, n - 1);
		cout << ans << endl;
	}

	return 0;
}