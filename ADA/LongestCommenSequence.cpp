#include<iostream>
using namespace std;

void solve(string x, string y, int a, int b)
{
      int A[a+1][b+1];
      char sign[a+1][b+1];

      for(int i = 0; i<=a; i++)
      {
        for(int j = 0; j<=b; j++)
        {
            A[i][j] = 0;
            sign[i][j] = 0;
        }
      }

      for(int i = 0; i<a; i++)
      {
          char ch = x[i];

          for(int j = 0; j<b; j++)
          {
                
               if(ch == y[j])
               {
                 A[i+1][j+1] = A[i][j] + 1;
                 sign[i+1][j+1] = '\\';
               }else
               {
                   if(A[i][j+1] >= A[i+1][j])
                   {
                       A[i+1][j+1] = A[i][j+1];
                       sign[i+1][j+1] = '^';
                   }else
                   {
                     A[i+1][j+1] = A[i+1][j];
                       sign[i+1][j+1] = '<';
                   }
               }
          }
         
        }

        int i = a;
        int j = b;
        string result = "";
        while(i>0 && j>0)
        {
            if(sign[i][j] == '<')
            {
                j--;
            }else  if(sign[i][j] == '^'){
                i--;
            }else{
               result=x[i-1]+result;
               i--;
               j--;
            }
        }

        cout<<result<<endl;
        cout<<"Length Of LCS :- "<<A[a][b];

}

int main(){
    string x = "ABDCEFKGH";
    string y = "BECDFKAG";

    int a = 9;  // Length of x
    int b = 8;  // Length of y

    cout<<endl;
    cout<<"String A = "<<x<<"\n";
    cout<<"String B = "<<y<<"\n";

cout<<"Longest Common Sequence : ";
    solve(x,y,a,b);

}