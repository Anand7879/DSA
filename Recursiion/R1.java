package Recursiion;

public class R1 {
    public static void main(String[] args) {
        func(1);
       
    }

    static void func(int n)
    {
        if(n > 5 )
        return;
        System.out.println("Anand");
        n++;
        func(n);
    }
}
