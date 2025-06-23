#include<iostream>
using namespace std;
#define max 4


void swap(int arr[max][max], int row, int col, int r, int c){
    int temp = arr[row][col];
    arr[row][col] = arr[r][c];
    arr[r][c] = temp;
}

int missPlaces(int iniArr[max][max], int goalArr[max][max]){
    int count = 0;
    for(int i=0; i<max; i++){
        for(int j=0; j<max; j++){
            if(iniArr[i][j] != 0 && iniArr[i][j] != goalArr[i][j]){
                count++;
            }
        }
    }
    return count;
}

void solution(int initialArr[max][max], int goalArr[max][max]){

  int Totalcost = 0;
char previous = 'a';
int maxswap = 0;
  while(true)
  {
    
    int MissPlaces[4] = {-1};
    
    // Finding position of Space     
    int row = 0, col = 0;
    for(int i=0; i<max; i++){
        for(int j=0; j<max; j++){
            if(initialArr[i][j] == 0){
                row = i;
                col = j;
            }
        }
    }  
    

     int temp[max][max];

        // up
        if(previous != 'd' && row-1 != -1){
           
              for(int i=0; i<max; i++){
                  for(int j=0; j<max; j++){
                       temp[i][j] = initialArr[i][j];
                  }
                }

            swap(temp, row-1, col, row, col);
            MissPlaces[0] = missPlaces(temp, goalArr);
        }

        //down
         if(previous != 'u' && row+1 != max){
           
              for(int i=0; i<max; i++){
                  for(int j=0; j<max; j++){
                       temp[i][j] = initialArr[i][j];
                  }
                }

            swap(temp, row+1, col, row, col);
            MissPlaces[1] = missPlaces(temp, goalArr);
        }

        // right
         if(previous != 'l' && col+1 != max){
           
              for(int i=0; i<max; i++){
                  for(int j=0; j<max; j++){
                       temp[i][j] = initialArr[i][j];
                  }
                }

            swap(temp, row, col+1, row, col);
            MissPlaces[2] = missPlaces(temp, goalArr);
        }

        // left
         if(previous != 'r' && col-1 != -1){
           
              for(int i=0; i<max; i++){
                  for(int j=0; j<max; j++){
                       temp[i][j] = initialArr[i][j];
                  }
                }

            swap(temp, row, col-1, row, col);
            MissPlaces[3] = missPlaces(temp, goalArr);
        }


         int minCost = INT32_MAX;

        int select = -1;
        for(int i=0; i<4; i++){
            if(MissPlaces[i] != -1 && MissPlaces[i] < minCost){
                minCost = MissPlaces[i];
                select = i;
            }
        }

        maxswap++;
        Totalcost+= 1+minCost;

        if(select == 0){

            previous = 'u';
              for(int i=0; i<max; i++){
                  for(int j=0; j<max; j++){
                       temp[i][j] = initialArr[i][j];
                  }
                }
                  swap(temp, row-1, col, row, col);

                   for(int i=0; i<max; i++){
                  for(int j=0; j<max; j++){
                       initialArr[i][j] = temp[i][j];
                  }
                }
        } else if(select == 1){

            previous = 'd';
              for(int i=0; i<max; i++){
                  for(int j=0; j<max; j++){
                       temp[i][j] = initialArr[i][j];
                  }
                }
                  swap(temp, row+1, col, row, col);

                   for(int i=0; i<max; i++){
                  for(int j=0; j<max; j++){
                       initialArr[i][j] = temp[i][j];
                  }
                }
        }else if(select == 2){
              previous = 'r';
              for(int i=0; i<max; i++){
                  for(int j=0; j<max; j++){
                       temp[i][j] = initialArr[i][j];
                  }
                }
                  swap(temp, row, col+1, row, col);

                   for(int i=0; i<max; i++){
                  for(int j=0; j<max; j++){
                       initialArr[i][j] = temp[i][j];
                  }
                }
        } else if(select==3){
               previous = 'l';
              for(int i=0; i<max; i++){
                  for(int j=0; j<max; j++){
                       temp[i][j] = initialArr[i][j];
                  }
                }
                  swap(temp, row, col-1, row, col);

                   for(int i=0; i<max; i++){
                  for(int j=0; j<max; j++){
                       initialArr[i][j] = temp[i][j];
                  }
                }
        } else{
            previous = 'a';
        }

        cout<<"Stage "<<maxswap<<":"<<endl;
       
        for(int i = 0; i<max; i++)
        {
            for(int j = 0; j<max; j++)
            {
                 cout<<initialArr[i][j]<<" ";
            }
            cout<<endl;
        }
        cout<<endl;


         if(minCost == 0){
            cout<<"Max Swapping: "<<maxswap<<endl;
            cout<<"Total Cost : "<<Totalcost<<endl;
            return;
        } 

  }




}


int main(){

    int IntialArr[max][max] = {
        {1,2,3,4},
        {5,6,0,8},
        {9,10,7,11},
        {13,14,15,12}
    };

    // Here 0 represent space
    cout<<"Intial Stage : "<<endl;

    for(int i = 0; i<max; i++)
    {
        for(int j = 0; j< max; j++)
        {
            cout<<IntialArr[i][j]<<" ";
        }
        cout<<endl;
    }
    cout<<endl;

     int GoalArr[max][max] = {
        {1,2,3,4},
        {5,6,7,8},
        {9,10,11,12},
        {13,14,15,0}
    };

solution(IntialArr,GoalArr);

}
