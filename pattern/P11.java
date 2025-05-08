public class P11 {
    public static void main(String[] args) {
        int n = 5;
        int k=0;
        for(int i = 0; i<n; i++)
        {   
            if(i%2==0)
            {   
              k=1;
            }
            else
            k=0;
            for(int j = 0; j<=i; j++)
            {
                System.out.print(k);
                k=1-k;
            }
            System.out.println();
        }
    }
    
}
