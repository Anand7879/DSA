public class P14 {
    public static void main(String[] args) {
    
        int n=4;
        
        for(int i = 0; i<n; i++)
        {
            char ch = 65;
            for(int j=0; j<=i; j++)
            {
                System.out.print(" "+ch);
                ch++;
            }
            System.out.println();
        }
    }
    
}
