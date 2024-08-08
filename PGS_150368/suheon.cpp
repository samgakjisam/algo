#include <string>
#include <vector>
#include <algorithm>
#include <iostream>

using namespace std;

vector <int> v;
int max_cnt = 0;
int max_summation = 0;

void f(int s, int N, vector<vector<int>> users, vector<int> emoticons){
    if (s == N){
        // 계산
        int summation = 0;
        int cnt = 0;
        for (int i = 0; i < users.size(); i++){
            int ff = users[i][0]; // 기준 할인율
            int ss = users[i][1]; // 기준 금액
            
            int tmp_price = 0;
            
            for (int j = 0; j < N; j++){
                if (ff <= v[j]) {
                    tmp_price += emoticons[j] * (100 - v[j]) / 100;
                }
            }
            
            if (tmp_price >= ss){
                cnt++;
            }
            else{
                summation += tmp_price;
            }
        }
        
        if (max_cnt < cnt){
            max_cnt = cnt;
            max_summation = summation;
        }
        else if(max_cnt == cnt && max_summation < summation){
            max_summation = summation;
        }
        
        return;
    }
    else{
        for (int i = 1; i < 5; i++){
            v.push_back(i * 10);
            f(s+1, N, users, emoticons);
            v.pop_back();
        }
    }
}

vector<int> solution(vector<vector<int>> users, vector<int> emoticons) {
    vector<int> answer;
    // 이상 할인이면 무조건 사 + 구매가격 10000 넘어가면 이모티콘 플러스
    
    int cnt = 0;
    int price = 0;
    
    f(0,emoticons.size(), users, emoticons);
    answer.push_back(max_cnt);
    answer.push_back(max_summation);
    return answer;
}
