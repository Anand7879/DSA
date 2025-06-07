#include<iostream>
using namespace std;
#define MAX 100

int G[MAX][MAX]; 
int X[MAX]; 

void Nextval(int k,int m,int n)
{
    while(true)
    {
        X[k] = ((X[k]+1 )  %  (m+1));

        if(X[k] == 0)
        {
            return;
        }
int j;
        for(j = 1; j<=n; j++)
        {
            if(G[j][k] != 0 && X[j] == X[k])
            {
                break;
            }

        }
        if(j == n+1)
        return;
    }
}

void MColouring(int k, int m, int n)
{
    while(true)
    {
        Nextval(k,m,n);

        if(X[k] == 0)
        {
            return;
        }

        if(k==n){
               for (int i = 1; i <= n; i++)
                cout << X[i] << " ";
                cout<<endl;
        } else {
            MColouring(k + 1,m,n);
        }
        

    }
}

 int main()
 {
    //  int  n = 5; // Number of vertices

    // for (int i = 1; i <= n; i++)  
    //     for (int j = 1; j <= n; j++)
    //         G[i][j] = 0;

    // G[1][2] = G[2][1] = 1;
    // G[1][4] = G[4][1] = 1;
    // G[2][3] = G[3][2] = 1;
    // G[2][5] = G[5][2] = 1;
    // G[3][5] = G[5][3] = 1;
    // G[3][4] = G[4][3] = 1;


      int  n = 4; // Number of vertices

    for (int i = 1; i <= n; i++)  
        for (int j = 1; j <= n; j++)
            G[i][j] = 0;

    G[1][2] = G[2][1] = 1;
    G[1][4] = G[4][1] = 1;
    G[2][3] = G[3][2] = 1;
    G[3][4] = G[4][3] = 1;

    for (int i = 1; i <= n; i++)
        X[i] = 0;

    X[1] = 1; // Starting from vertex 1

   int m = 3; // Chromatic number

     cout<<"\n";
    cout << " Ways Of colouring" << ":\n";
    MColouring(2,m,n);

 }