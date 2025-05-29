package ADA;

public class DynamicKnapSack {
    public static void main(String[] args) {
        int[] price = {10,40,30,20};
        int[] weight = {20,30,10,40};
        int m  = 70; //Maximum Capacity
        knapSack(price, weight, m);

        //  int price2[] = {60,80,50,75,65};
        //  int weight2[] = {30,45,25,27,18};
        //  int m2 = 105;
        // knapSack(price2, weight2, m2);



    }

    static int MergingPerging(int[][] temp,int[][][] touple,int m,int[] pairCount,int idx){

        int[][] Additional = new int[2*pairCount[idx-1]][2];
        int count = 0;
        pairCount[idx] = 0;
        
        for(int i = 0; i<pairCount[idx-1]; i++)
        {
           if(touple[idx-1][i][1] <= m){
                Additional[count][0] = touple[idx-1][i][0];
                Additional[count][1] = touple[idx-1][i][1];
                count++;
           }
        }

        for(int i = 0; i<pairCount[idx-1]; i++)
        {
           if(temp[i][1] <= m){
                Additional[count][0] = temp[i][0];
                Additional[count][1] = temp[i][1];
                count++;
           }
        }
        boolean[] discard = new boolean[count];

        for(int i = 0; i<count; i++)
        {
            int pi = Additional[i][0];
            int wi = Additional[i][1];


               for(int j = 0; j<count; j++)
               {
                   
                if(i==j)  continue;

                int pj = Additional[j][0];
                int wj = Additional[j][1];

                if(pi > pj && wi < wj)
                {
                    discard[j] = true;
                }

               }
        }
        int resultCount = 0;

        for(int i = 0; i<count; i++)
        {
            if(discard[i]) continue;
            
            int pi = Additional[i][0];
            int wi = Additional[i][1];

            boolean duplicate = false;


            for(int k = 0; k<resultCount; k++)
            {
                if(touple[idx][k][0] == pi && touple[idx][k][1] == wi)
                {
                    duplicate = true;
                    break;
                }
            }
           if(!duplicate){

             touple[idx][resultCount][0] = pi;
             touple[idx][resultCount][1] = wi;
             pairCount[idx]++;
             resultCount++;

            }     
        }

        
        
        System.out.print("S"+idx+" = ");
        for(int i = 0; i< pairCount[idx]; i++)
        {
            System.out.print("("+ touple[idx][i][0] + ", "+ touple[idx][i][1] +")" + ", ");
        }
        System.out.println();
        System.out.println();

       
        return idx+=1;

    }

     static void knapSack(int[] price , int[] weight, int m)
    {
      int n = price.length;
      int idx = 1;
      int max = 1000;
      int[][][] touple = new int[n+1][max][2];
      
      touple[0][0][0] = 0;
      touple[0][0][1] = 0;

      int[] pairCount = new int[n+1];

      pairCount[0] = 1;

      for(int i  = 0; i<n; i++){

        int x = price[i];
        int y = weight[i];
        
        int[][]temp = new int[pairCount[i]][2];
        for(int j = 0; j<pairCount[i]; j++)
        {
             temp[j][0] = touple[i][j][0]+x;
             temp[j][1] = touple[i][j][1]+y;
        }

         idx = MergingPerging(temp, touple, m, pairCount, idx);

        }
        
        int maxprofit = 0; 

        for(int j = 0; j<pairCount[n]; j++)
        {
            if(touple[n][j][0]>maxprofit)
            {
                maxprofit = touple[n][j][0];
            }
        }

        System.out.print("Maximum Profit :- ");
        System.out.print(maxprofit);
        System.out.println();



// Find (maxProfit, weight) pair in touple[n]
         int finalWeight = 0;
     for (int j = 0; j < pairCount[n]; j++) {
      if (touple[n][j][0] == maxprofit) {
        finalWeight = touple[n][j][1];
        break;
    }
       }

// Backtrack
int[] result = new int[n];
int profit = maxprofit;
int weightNow = finalWeight;

for (int i = n; i > 0; i--) {
    boolean foundInPrev = false;
    for (int j = 0; j < pairCount[i - 1]; j++) {
        if (touple[i - 1][j][0] == profit && touple[i - 1][j][1] == weightNow) {
            // Found same pair → item i-1 not selected
            result[i - 1] = 0;
            foundInPrev = true;
            break;
        }
    }

    if (!foundInPrev) {
        // Not found → item i-1 was selected
        result[i - 1] = 1;
        profit -= price[i - 1];
        weightNow -= weight[i - 1];
    }
}

// Step 3: Print selected items
System.out.println("\nSelected Items (0/1):");
for (int k = 0; k < n; k++) {
    System.out.print(result[k] + " ");
}
System.out.println();


    }
    


}
