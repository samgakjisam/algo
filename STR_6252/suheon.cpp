#include<iostream>
#include <algorithm>

using namespace std;

unsigned long long arr[100001] = {0, };
int N;
unsigned long long B;

unsigned long long cal(unsigned long long m) {

    unsigned long long cost = 0;
    
    for(int i = 0; i < N; i++){
        if(m > arr[i]) cost += (m - arr[i]) * (m - arr[i]);
    }
    
    return cost;
}

int main(int argc, char** argv)
{
    cin >> N >> B;
    
    for (int i = 0; i < N; i++){
        cin >> arr[i];
    }

    sort(arr, arr+N);

    // 최저 성능 이분 탐색
    unsigned long long left = arr[0];
    // int right = arr[N-1];
    unsigned long long right = 2000000000;

    unsigned long long max_per = 0;

    while(left <= right){
        unsigned long long mid = (left + right) / 2;

        unsigned long long result = cal(mid);

        if (result <= B){
            if (max_per < mid) max_per = mid;
            left = mid + 1;
        }
        else{
            right = mid - 1;
        }
    }
    
    cout << max_per;
   return 0;
}
