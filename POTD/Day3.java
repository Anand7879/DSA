package POTD;

// import java.util.Arrays;

public class Day3 {

    public static void main(String[] args) {
        System.out.println(kthSmallest(3,3,5));
    }

    public static int kthSmallest(int m, int n, int k) {
        // code here
        
// Brute Force Approach

        // int [][] mat = new int [m][n];
        // int [] Arr = new int[m*n];
        // for(int i = 0; i<m; i++)
        // {
        //     for(int j = 0; j<n; j++)
        //     {
        //         mat[i][j] = (i+1)*(j+1);
        //     }
        // }

        // int index = 0;
        // for(int i = 0; i<m; i++)
        // {
        //     for(int j = 0; j<n; j++)
        //     {
        //       Arr[index++] = mat[i][j];
        //     }
        // }
        
        // Arrays.sort(Arr);
        // return Arr[k-1];
        
// Optimal Approach

    int low = 1, high = m * n;

    while (low < high) {
        int mid = low + (high - low) / 2;
        int count = 0;

        for(int i = 1; i<=m; i++)
        {
            count+=Math.min(mid/i, n);
        }

        if (count < k) {
            low = mid + 1;
        } else {
            high = mid;
        }
    }

    return low;

   
    }

}   