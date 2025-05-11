package GFG160;

public class Problem6 {
    public static void main(String[] args) {
        int [] prices = {100, 180, 260, 310, 40, 535, 695};
        // int [] prices = {4, 2, 2, 2, 4};
        int m = maximumProfit(prices);
        System.out.println("Maximum Profit : "+ m);
    }
    // The cost of stock on each day is given in an array price[].
    //  Each day you may decide to either buy or sell the stock i at price[i], 
    // you can even buy and sell the stock on the same day. 
    // Find the maximum profit that you can get.
   
    // Note: A stock can only be sold if it has been bought previously and 
    // multiple stocks cannot be held on any given day.

    
    public static int maximumProfit(int prices[]) {
        // code here
         
        int profit = 0;
        
        for(int i = 1; i<prices.length; i++)
        {
            if(prices[i]>prices[i-1])
            {
                profit+= (prices[i]-prices[i-1]);
            }
        }
        return profit;

    }
    
}
