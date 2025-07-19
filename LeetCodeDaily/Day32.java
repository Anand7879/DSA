// Date: 19th July 2025
// Day: Saturday

import java.util.*;

public class Day32 {
    public static void main(String[] args) {
        String[] folderArray = {"/a", "/a/b", "/c/d", "/c/d/e", "/c/f"};

        Day32 obj = new Day32();
        List<String> result = obj.removeSubfolders(folderArray);

        System.out.println(result); // Output: [/a, /c/d, /c/f]
    }

    public List<String> removeSubfolders(String[] folder) {
        Arrays.sort(folder);  // Sort lexicographically

        List<String> result = new ArrayList<>();

        for (String current : folder) {
            // Check if current is not a subfolder of last added
            if (result.isEmpty() || !current.startsWith(result.get(result.size() - 1) + "/")) {
                result.add(current);
            }
        }

        return result;
    }
}
