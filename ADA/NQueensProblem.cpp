#include<iostream>
using namespace std;
#define MAX 100
int X[MAX];     


bool place(int i, int j)
{
    for(int k = 1; k<=i-1; k++)
    {
        if(X[k] == j || (abs(i-k) == abs(X[k]-j)))
        {
            return false;
        }

    }
    return true;
}

void NQ(int i, int N)
{
    for(int j = 1; j<=N; j++)
    {
        if(place(i,j))
        {
            X[i] = j;

            if(i == N)
            {
                for(int row = 1; row<=N; row++)
                {
                 cout<<X[row]<<" ";
                }
                cout<<endl;
            }else{
             NQ(i+1,N);
            }
        }

    }
}

int main(){

    int N;
    cout<<endl;
    cout<<"Enter No. Of Queens (N) : ";
    cin>>N;
  
     for (int i = 1; i <= N; i++)
        X[i] = 0;

      cout<<endl;
      cout<<"Solutions are : "<<endl;
    NQ(1,N);

}