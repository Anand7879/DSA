public class Day41 {
    public static void main(String[] args) {
        
    }
    int max = 0, count = 0;
    public int countMaxOrSubsets(int[] nums) {
        // Step 1: Find max OR of the array
        for (int num : nums) {
            max |= num;
        }

        // Step 2: Start backtracking from index 0 with OR = 0
        dfs(nums, 0, 0);
        return count;
    }

    private void dfs(int[] nums, int index, int currOr) {
        if (index == nums.length) {
            if (currOr == max) {
                count++;
            }
            return;
        }

        // Include current number
        dfs(nums, index + 1, currOr | nums[index]);

        // Exclude current number
        dfs(nums, index + 1, currOr);
    }
}

