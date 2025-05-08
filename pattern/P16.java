public class P16 {
    public static void main(String[] args) {
        int n=4;
        for(int i = 1; i<=n; i++)
        {
            char ch = 65;
            
            for(int j=0; j<n-i; j++)
            {
                System.out.print(" "+" ");
            }
            for(int k =0; k<i; k++)
            {
                
                System.out.print(ch+" ");
                ch++;
            }

            ch-=2;
            for(int l=1; l<i; l++)
            {
                System.out.print(ch+" ");
                ch--;

            }
            
            System.out.println();
        
        }
    }
    
}
