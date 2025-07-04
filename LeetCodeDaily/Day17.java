// Date 4th july 2025
// Day Friday

public class Day17 {
    public static void main(String[] args) {
       int k = 5;
       int[] operations = {0,0,0};
       System.out.println(kthCharacter(k, operations));
    }

    public static char kthCharacter(long k, int[] operations) {
        StringBuilder str = new StringBuilder();
        str.append("a");

        for(int i = 0; i<operations.length; i++)
        {
            if(operations[i]==0)
            {
                str.append('a');
            }else{
                
            }

        }

    }
}
