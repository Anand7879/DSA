public class P20 {
    public static void main(String[] args) {
        int n = 10;
        int Space = 2*n-2;
        for(int i = 1; i<=n; i++)
        {
            for(int j=1;j<=i;j++){
                System.out.print("*");
            }
            for(int j=0;j<Space; j++)
            {
                 System.out.print(" ");
                 
            }
            for(int k =0; k<i; k++ )
            {
                System.out.print("*");
            }
            System.out.println();
            if(i!=n)
            Space-=2;
        }

          Space+=2;
          for(int i = 1; i<n; i++)
        {
            for(int j=n-1;j>=i;j--){
                System.out.print("*");
            }
            for(int j=0;j<Space; j++)
            {
                 System.out.print(" ");
                 
            }
            for(int k =n-1; k>=i; k-- )
            {
                System.out.print("*");
            }
            System.out.println();
            Space+=2;
        }
    }
    
}
