// Date 4th july 2025
// Day Friday

public class Day17 {
    public static void main(String[] args) {
    //    long k = 5;
    //    int[] operations = {0,0,0};
    //    System.out.println(kthCharacter(k, operations));

      long k = 10;
       int[] operations = {0,1,0,1};
           System.out.println(kthCharacter(k, operations));

    }

    public static char kthCharacter(long k, int[] operations) {
        StringBuilder str = new StringBuilder();
        str.append("a");

        for(int i = 0; i<operations.length; i++)
        {
            if(operations[i]==0)
            {
                str.append(str);
            }else{
                int len = str.length(); 
                for (int j = 0; j < len; j++) {
                    char nextChar = (char)(str.charAt(j) + 1);
                    str.append(nextChar);
            }

        }

    }
    return str.charAt((int)k - 1);
}

// Optimal Solution

    public char kthCharacter(long k, int[] operations) {
        int increases = 0;
        int ops = (int) Math.ceil(Math.log(k) / Math.log(2));

        for (int i = ops - 1; i >= 0; i--) {
            long half = 1L << i;
            if (k > half) {
                k -= half;
                increases += operations[i];
            }
        }

        return (char)('a' + increases % 26);
    }




}
