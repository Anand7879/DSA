// Date 6th july 2025
// Day Sunday
import java.util.HashMap;
import java.util.Map;

class FindSumPairs {
private int[] nums1;
private int[] nums2;
private Map<Integer, Integer> freqNums2;

public FindSumPairs(int[] nums1, int[] nums2) {
    this.nums1 = nums1;
    this.nums2 = nums2;
    this.freqNums2 = new HashMap<>();

    for (int num : nums2) {
        freqNums2.put(num, freqNums2.getOrDefault(num, 0) + 1);
    }
}

public void add(int index, int val) {
    int oldVal = nums2[index];
    int newVal = oldVal + val;

    freqNums2.put(oldVal, freqNums2.get(oldVal) - 1);
    if (freqNums2.get(oldVal) == 0) {
        freqNums2.remove(oldVal);
    }

    nums2[index] = newVal;
    freqNums2.put(newVal, freqNums2.getOrDefault(newVal, 0) + 1);
}

public int count(int tot) {
    int result = 0;
    for (int num : nums1) {
        int target = tot - num;
        result += freqNums2.getOrDefault(target, 0);
    }
    return result;
}
}

public class Day19{
public static void main(String[] args) {
int[] nums1 = {1, 1, 2, 2, 2, 3};
int[] nums2 = {1, 4, 5, 2, 5, 4};

    FindSumPairs obj = new FindSumPairs(nums1, nums2);

    System.out.println("count(7): " + obj.count(7)); // Expected: 6
    obj.add(3, 2); // nums2[3] += 2 → nums2[3] = 4
    System.out.println("count(8): " + obj.count(8)); // Expected: 2
    obj.add(0, 1); // nums2[0] += 1 → nums2[0] = 2
    System.out.println("count(6): " + obj.count(6)); // Expected: 3
}
}