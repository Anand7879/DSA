public class something {
    public static void main(String[] args) {
        String str = "hannahn";

        int n = str.length();
        boolean palindrome = true;

        for(int i = 1; i<=n/2; i++)
        {
            if(str.charAt(i-1)!=str.charAt(n-i)){
                 palindrome = false;
                 break;
            }
        }

        if(palindrome){
            System.out.println("palindrom");
        }
    }
    
}
