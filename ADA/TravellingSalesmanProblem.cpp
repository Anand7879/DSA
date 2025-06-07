#include<iostream>
using namespace std;
#define MAX 100

int g[MAX][MAX];
int Cost[MAX][MAX]; 


void Travelling(int n){

    for(int i = 1; i<n; i++)
    {
        for(int j = 2; j<16; j++)
        {
            g[i][j];
        }
    }

}


int main(){

    int n = 4;  // No. Of Vertices
    
    //  Cost Matrix
    int cost[n][n] = {
        {0, 3, 5, 4},
        {4, 0, 6, 3},
        {2, 7, 0, 4},
        {5, 3, 2, 0}
    };

Travelling(n);


}