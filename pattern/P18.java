public class P18 {
    public static void main(String[] args) {
        int n = 5;
        char ch = 65+5;
        
        for(int i=1; i<=n; i++)
        {
             ch-=i;
            for(int j = 0; j<i; j++)
            {
                System.out.print(ch+" ");
                ch++;
            }
            System.out.println();
        }
    }
    
}
