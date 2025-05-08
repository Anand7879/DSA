import java.util.Scanner;
 public class P1{
    public static void main(String[] args) {
        // pattern1();
        // pattern2(5);
        pattern3(6);
    }
    public static void pattern1(){
        int n;
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter n : ");
        n = sc.nextInt();

        for(int i = 0; i<n; i++)
        {
            for(int j = 0; j<n; j++)
            {
                System.out.print("*");
            }
            System.out.println();
        }

    } 

    public static void pattern2(int n)
        {
             for(int i =0; i<n; i++)
             {
                for(int j=0;j<i;j++)
                {
                    System.out.print("*");
                }
                System.out.println();
             }
        }
    
        public static void pattern3(int n)
        {   
             for(int i =1; i<=n; i++)
             {
                for(int j=0;j<i;j++)
                {
                    System.out.print(i);
                }
                System.out.println();
             }
        }
    
}