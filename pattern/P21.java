public class P21 {
    public static void main(String[] args) {
        int n = 4;
        for(int i = 1; i<=n; i++)
        {
            for(int j = 0; j<n; j++)
            {
               if(i==1 || i==n || j==0 || j==n-1)
               {
               System.out.print("*");
               }else
               {
                System.out.print(" ");
               }
            }
            System.out.println();
        }
    }
    
}
