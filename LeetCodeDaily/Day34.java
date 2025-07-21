// Date: 21st July 2025
// Day: Monday

public class Day34 {
    public static void main(String[] args) {
       String s = "aaabaaaa";
    System.out.println(makeFancyString(s));
    // makeFancyString(s);
    }

    public static String makeFancyString(String s) {
        
        char ch = s.charAt(0);
        int count = 1;
        String str ="";
        str=str+ch;
    
        for(int i = 1; i<s.length(); i++)
        {
             if(s.charAt(i)==ch){
                count++;
             }else{
                ch = s.charAt(i);
                count = 1;
             }

             if(count < 3){
                 str+=ch;
             }
        }

      return str;
    }
}
