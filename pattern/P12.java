public class P12 {
    public static void main(String[] args) {
        int n=4;

        for(int i = 1; i<=n; i++ )
        {
            for(int j = 1; j<=i; j++)
            {
                 System.out.print(j); 
            }
            for(int k = i; k<n*2-i; k++)
            {
                System.out.print("_");
            }
            for(int j = i; j>0; j--)
            {
                 System.out.print(j); 
            }
            System.out.println();
           
        }
    }
    
}
