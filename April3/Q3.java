//3.Problem Description

//        Given two words (start and end), and a dictionary, find the shortest transformation sequence from start to end, such that:
//        Only one letter can be changed at a time
//        Each intermediate word must exist in the dictionary
//
//        If there are multiple such sequences of the shortest length, return all of them.
//        Refer to the example for more details.
//
//        Note:
//        All words have the same length.
//        All words contain only lowercase alphabetic characters.
//
//
//        Input Format
//        The first argument is string start.
//        The second argument is string end.
//        The third argument is an array of strings dict
//
//
//        Output Format
//        Return all transformation sequences such that first word of each sequence is start and last word is end, all intermediate words belongs to dictionary(dict) and consecutive words had atmost 1 difference.
//
//
//        Example Input
//        start = "hit"
//        end = "cog"
//        dict = ["hot","dot","dog","lot","log"]<>/pre
//
//
//        Example Output
//        [
//        ["hit","hot","dot","dog","cog"],
//        ["hit","hot","lot","log","cog"]
//        ]
package April3;

import java.util.*;

public class Q3 {

    public List<List<String>> findLadders(String start, String end, List<String> dict) {
        List<List<String>> result = new ArrayList<>();
        Set<String> dictionary = new HashSet<>(dict);
        if (!dictionary.contains(end)) {
            return result;
        }

        Map<String, List<String>> graph = new HashMap<>();
        Set<String> visited = new HashSet<>();
        Queue<List<String>> queue = new LinkedList<>();
        queue.offer(Arrays.asList(start));

        boolean found = false;
        while (!queue.isEmpty() && !found) {
            int size = queue.size();
            Set<String> currentLevelVisited = new HashSet<>();
            for (int i = 0; i < size; i++) {
                List<String> path = queue.poll();
                String currentWord = path.get(path.size() - 1);

                char[] wordArray = currentWord.toCharArray();
                for (int j = 0; j < wordArray.length; j++) {
                    char originalChar = wordArray[j];
                    for (char c = 'a'; c <= 'z'; c++) {
                        wordArray[j] = c;
                        String newWord = new String(wordArray);
                        if (dictionary.contains(newWord)) {
                            List<String> newPath = new ArrayList<>(path);
                            newPath.add(newWord);
                            queue.offer(newPath);
                            currentLevelVisited.add(newWord);
                            if (newWord.equals(end)) {
                                found = true;
                                result.add(newPath);
                            }
                        }
                    }
                    wordArray[j] = originalChar;
                }
            }
            visited.addAll(currentLevelVisited);
            dictionary.removeAll(currentLevelVisited);
        }

        return result;
    }

    public static void main(String[] args) {
        String start = "hit";
        String end = "cog";
        List<String> dict = Arrays.asList("hot", "dot", "dog", "lot", "log");

        Q3 solution = new  Q3();
        List<List<String>> sequences = solution.findLadders(start, end, dict);

        for (List<String> sequence : sequences) {
            System.out.println(sequence);
        }
    }
}
