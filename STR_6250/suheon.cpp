#include<iostream>
#include <vector>
#include <algorithm>

using namespace std;

int N; // 참가자의 수 3 ~ 100,000 대회는 3개
vector <vector<int>> score_num;
vector <vector<int>> sum;
int ans[4][100000];

void cal_rank(int ii, vector<vector<int>> v){
    
    sort(v.begin(),v.end());

    int rank = 1;
    int before = 1;
    
    for(int i=0;i<v.size();i++){
        int score = v[i][0];
        int num = v[i][1];

        if (before == score){ // 동점이면
            ans[ii][num] = rank;
        }
        else{
            ans[ii][num] = i+1;
            rank = i+1;
        }
        
        before = score;
    }
}

int main(int argc, char** argv)
{
    cin >> N;
    // n번 대회 등수와 최종 등수 출력
    
    // 점수 입력
    for(int i=0;i<3;i++){ // 대회
        for(int j=0;j<N;j++){ // 학생
            int tmp;
            cin >> tmp;
            
            vector <int> v;
            v.push_back(-tmp);
            v.push_back(j);
            score_num.push_back(v);
            
            if (i == 0){
                sum.push_back(v);
            } 
            else{
                sum[j][0] += -tmp;
            }
        }
        cal_rank(i,score_num);
        score_num.clear();
    }
    // 합산 계산
    cal_rank(3,sum);
    
    for(int i=0;i<4;i++){
        for(int j=0;j<N;j++){
            cout << ans[i][j] << " ";
        }
        cout << endl;
    }
    
   return 0;
}
