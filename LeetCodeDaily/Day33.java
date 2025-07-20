import java.util.*;

class Solution {
    static class Node {
        String name;
        Map<String, Node> children = new HashMap<>();
        boolean isDeleted = false;
    }

    Node root = new Node();  // dummy root (not an actual folder)
    Map<String, Integer> serialFreq = new HashMap<>();
    Map<String, List<Node>> serialToNodes = new HashMap<>();

    public List<List<String>> deleteDuplicateFolder(List<List<String>> paths) {
        // Step 1: Build the tree
        for (List<String> path : paths) {
            Node curr = root;
            for (String folder : path) {
                curr.children.putIfAbsent(folder, new Node());
                curr = curr.children.get(folder);
                curr.name = folder;
            }
        }

        // Step 2: Serialize all children of root (skip dummy root)
        for (Node child : root.children.values()) {
            serialize(child);
        }

        // Step 3: Mark duplicates
        for (Map.Entry<String, List<Node>> entry : serialToNodes.entrySet()) {
            if (serialFreq.get(entry.getKey()) > 1) {
                for (Node node : entry.getValue()) {
                    node.isDeleted = true;
                }
            }
        }

        // Step 4: Collect valid paths
        List<List<String>> result = new ArrayList<>();
        for (Node child : root.children.values()) {
            collectPaths(child, new ArrayList<>(), result);
        }

        return result;
    }

    private String serialize(Node node) {
        if (node.children.isEmpty()) return "";

        StringBuilder sb = new StringBuilder();
        for (String key : new TreeSet<>(node.children.keySet())) {
            Node child = node.children.get(key);
            sb.append("(").append(key).append(serialize(child)).append(")");
        }

        String serial = sb.toString();
        serialFreq.put(serial, serialFreq.getOrDefault(serial, 0) + 1);
        serialToNodes.computeIfAbsent(serial, k -> new ArrayList<>()).add(node);
        return serial;
    }

    private void collectPaths(Node node, List<String> path, List<List<String>> result) {
        if (node.isDeleted) return;

        path.add(node.name);
        result.add(new ArrayList<>(path));

        for (Node child : node.children.values()) {
            collectPaths(child, path, result);
        }

        path.remove(path.size() - 1);
    }
}

public class Day33 {
    public static void main(String[] args) {
        Solution sol = new Solution();

        List<List<String>> input = List.of(
            List.of("a"),
            List.of("c"),
            List.of("d"),
            List.of("a", "b"),
            List.of("c", "b"),
            List.of("d", "a")
        );

        List<List<String>> output = sol.deleteDuplicateFolder(input);

        if (output.isEmpty()) {
            System.out.println("No remaining folders.");
        } else {
            for (List<String> path : output) {
                System.out.println(String.join("/", path));
            }
        }
    }
}
