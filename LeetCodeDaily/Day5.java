// Date 22th june 2025
// Day sunday

import java.util.ArrayList;
import java.util.Scanner;

public class Day5 {
    public static void main(String[] args) {
        
      Scanner sc = new Scanner(System.in);
        System.out.print("Enter String : ");
        String str = sc.nextLine();
        System.out.print("Enter K : ");
        int k = sc.nextInt();
        System.out.print("Enter fill Character : ");
        char fill = sc.next().charAt(0);


           ArrayList<String> list = new ArrayList<>();
           
           
           for(int i=0; i<str.length(); i+=k)
           {
                int end = Math.min(i + k, str.length()); 
                String temp = str.substring(i, end);
                
                while(temp.length()<k)
                {
                    temp+=fill;
                }
                
               list.add(temp);
           }

         String[] array = list.toArray(new String[0]);

         for (String string : array) {
            System.out.println(string);
         }

    }
}