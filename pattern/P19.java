public class P19 {
    public static void main(String[] args) {
        int n = 3;
        int Space = 0;
        for(int i = 0; i<n; i++)
        {
            for(int j=1;j<=n-i;j++){
                System.out.print("*");
            }
            for(int j=0;j<Space; j++)
            {
                 System.out.print(" ");
                 
            }
            for(int k =n; k>i; k-- )
            {
                System.out.print("*");
            }
            System.out.println();
            Space+=2;
        }


       Space-=2;
        // For Lower half
        for(int i = 1; i<=n; i++)
        {
            for(int j=0;j<i;j++){
                System.out.print("*");
            }
            for(int j=0;j<Space; j++)
            {
                 System.out.print(" ");
                 
            }
            for(int k =1; k<=i; k++ )
            {
                System.out.print("*");
            }
            System.out.println();
            Space-=2;
        }
    }
    
}
