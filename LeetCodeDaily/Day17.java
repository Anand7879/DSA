// Date 4th july 2025
// Day Friday

public class Day17 {
    public static void main(String[] args) {
    //    int k = 5;
    //    int[] operations = {0,0,0};

      int k = 10;
       int[] operations = {0,1,0,1};
    //    System.out.println(kthCharacter(k, operations));
    kthCharacter(k, operations);

    }

    public static void kthCharacter(long k, int[] operations) {
        StringBuilder str = new StringBuilder();
        str.append("a");

        for(int i = 0; i<operations.length; i++)
        {
            if(operations[i]==0)
            {
                str.append('a');
            }else{
                for(int j = 0; j<str.length(); j++)
                {
                    char nextchar =  (char) (str.charAt(i)+1);
                    str.append(nextchar);
                }
            }

        }

        System.out.println(str);
            
    }
}
