package GFG160;

public class Problem7 {
    public static void main(String[] args) {
        // int[] prices = {7, 10, 1, 3, 6, 9, 2};
        // int[] prices = {7, 6, 4, 3, 1};
        int[] prices = {1, 3, 6, 9, 11};
        System.out.println(maximumProfit(prices));

        
    }
    
//     Given an array prices[] of length n, 
//     representing the prices of the stocks on different days.
//     The task is to find the maximum profit possible by buying and selling 
//     the stocks on different days when at most one transaction is allowed.
//      Here one transaction means 1 buy + 1 Sell. If it is not possible to make a profit then return 0.

// Note: Stock must be bought before being sold.

public static int maximumProfit(int prices[]) {
        // Code here
      int n = prices.length;
      
      int minprice = Integer.MAX_VALUE;
     
      int maxprofit = 0;
      
       for(int i=0; i<n; i++ )
       {
           if(prices[i]<minprice)
           {
               minprice = prices[i];
           }else
           {
               maxprofit = Math.max(maxprofit,prices[i]-minprice);
           }
           
          
       }
       return maxprofit;
      
    }


}
