package Recursiion;

public class R2 {
    public static void main(String[] args) {
        func(1,100);
    }

     static void func(int count, int n)
    {
       if(count==n)
       return;
       System.out.println(count);
       count++;
       func(count, n);

    }
}
