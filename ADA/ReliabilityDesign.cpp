#include<iostream>
#define devices 100
#define max 100
#define copy 100
using namespace std;

double Tuple[devices][max][2];
double Copies[devices][copy][max][2];

double power(double x, double y){
    double result = 1;

    for(int i = 0; i<y; i++)
    {
        result*=x;
    }

    return result;
}

int MergingPerging(int maxCopy, int MaxCost, int pairCount[] ,int idx, double cost[], int n)
{
     double Additional[maxCopy*pairCount[idx-1]][2];

        int count = 0;
        pairCount[idx] = 0;

        for(int i = 0; i<maxCopy; i++){
              
              for(int j = 0; j<pairCount[idx-1]; j++)
              {
                   if(Copies[idx-1][i][j][1] <= MaxCost)      // Perging 1st Rule
                   {
                  Additional[count][0] = Copies[idx-1][i][j][0];
                  Additional[count][1] = Copies[idx-1][i][j][1];
                  count++;
                   }
              }

        }

       bool discard[count] = {false}; 

         for(int i = 0; i<count; i++)
        {
            double ri = Additional[i][0];
            double ci = Additional[i][1];

            if (idx-1 < n && ci + cost[idx] > MaxCost) {    // Perging 3rd rule
                   discard[i] = true;
                   continue;
              }


               for(int j = 0; j<count; j++)
               {
                   
                if(i==j)  continue;

                double rj = Additional[j][0];
                double cj = Additional[j][1];

                if(ri > rj && ci < cj )               // Perging 2nd Rule
                {
                    discard[j] = true;
                }

               }
        }

         int resultCount = 0;

        for(int i = 0; i<count; i++)
        {
            if(discard[i]) continue;
            
            double ri = Additional[i][0];
            double ci = Additional[i][1];

            bool duplicate = false;


            for(int k = 0; k<resultCount; k++)
            {
                if(Tuple[idx][k][0] == ri && Tuple[idx][k][1] == ci)
                {
                    duplicate = true;
                    break;
                }
            }
           if(!duplicate){

             Tuple[idx][resultCount][0] = ri;
             Tuple[idx][resultCount][1] = ci;
             pairCount[idx]++;
             resultCount++;

            }     
        }


          cout<<"S"<<idx<<" = ";
        for(int i = 0; i< pairCount[idx]; i++)
        {
          cout<<"("<<Tuple[idx][i][0] << ", "<< Tuple[idx][i][1] <<")" << ", ";
        }
       cout<<"\n";
       cout<<"\n";

       
        idx++;
return idx;

}

void ReliabilityDesign(double cost[], double reliablility[],int n, int MaxCost){
    
    Tuple[0][0][0] = 1;
    Tuple[0][0][1] = 0;
     
    cout<<"\n";
    cout<<"S0 = ";
    cout<<"("<<  Tuple[0][0][0]<<", "<<Tuple[0][0][1]<<")"<<","<<"\n\n"; 

     int idx = 1;
    int TotalCost = 0;
    for(int i = 0; i<n; i++)
    {
        TotalCost+=cost[i];
    }

    // Calculating Max Copy Of Each Devices
    int maxCopy[n];
    
    for(int i = 0; i<n; i++)
    {
        maxCopy[i] = ( MaxCost + cost[i] - TotalCost) / cost[i];
    }
    
    int pairCount[n+1];

    pairCount[0] = 1;
     
    int copyPairCount[max];

    for(int i = 0; i<n; i++){

       double r = reliablility[i];
       double c = cost[i];
       
        for(int j = 0; j<=maxCopy[i]; j++)
        {
            double mf = 0;
            mf = power(1-r,j+1);
            double ActualReli = 1-mf;
            
            for(int k = 0; k<pairCount[i]; k++)
            { 
                 Copies[i][j][k][0] = Tuple[i][k][0]*ActualReli;
                 Copies[i][j][k][1] = Tuple[i][k][1]+(c*(j+1));
            }

        }

     idx = MergingPerging(maxCopy[i],MaxCost,pairCount,idx,cost,n);
    }

     double m = 0, c = 0;

      for(int j=0; j<pairCount[n]; j++){
        if(Tuple[n][j][0] > m){
            m = Tuple[n][j][0];
            c = Tuple[n][j][1];
        }
    }
    cout<<"Maximum Reliability Tuple: ("<<m<<", "<<c<<")"<<endl;
    cout<<"\n";


    int result [n];
double rel = m;
double cos = c;

for (int i = n; i > 0; i--) {
    bool foundInPrev = false;
    for (int j = 0; j < maxCopy[i-1]; j++) {
          for(int k=0; k<pairCount[i-1]; k++)
           {
               if(Copies[i-1][j][k][0]== rel)
               {
                     result[i-1] = j+1;
                     rel = (rel / (1 - power(1 - reliablility[i-1], j + 1)));
               }
               
           }
        }
    }

    // Step 3: Print selected items
    cout<<"Exact Copies Of Each Device :- "<<"\n";
    for (int k = 0; k < n; k++) {
       cout<<"D"<<k+1<<" = "<<result[k];
       cout<<"\n";
    }
}

     

int main(){

     double cost[]   =   {20,15,30};
     double reliability[] = {0.8,0.7,0.9};
    int Max_Cost = 100;

    int device = 3;

    ReliabilityDesign(cost,reliability,device,Max_Cost);
}