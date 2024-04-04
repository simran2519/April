//1. Problem Description
//
//
//
//        Given an array of words and a length of L, format the text such that each line has exactly L characters and is fully (left and right) justified. You should pack your words in a greedy approach; that is, pack as many words as you can in each line.
//
//
//
//        Pad extra spaces ' ' when necessary so that each line has exactly L characters. Extra spaces between words should be distributed as evenly as possible. If the number of spaces on a line does not divide evenly between words, the empty slots on the left will be assigned more spaces than the slots on the right. For the last line of text, it should be left justified and no extra space is inserted between words.
//
//        Your program should return a list of strings, where each string represents a single line.
//
//        Note: Each word is guaranteed not to exceed L in length.
//
//
//
//        Problem Constraints
//        0 <= |A| <= 1000
//        0 <= B <= 5 * 104
//
//
//        Input Format
//        The first argument is an array of strings A representing words.
//        The second argument is an integer B representing L.
//
//
//        Output Format
//        Return a list of strings, where each string represents a single line.
//
//
//        Example Input
//        A: ["This", "is", "an", "example", "of", "text", "justification."]
//        B: 16.
//
//
//        Example Output
//        [
//        "This    is    an",
//        "example  of text",
//        "justification.  "
//        ]
//
//
//        Example Explanation
//        Given words: ["This", "is", "an", "example", "of", "text", "justification."]
//        L: 16.
//
//
//        Return the formatted lines as:
//        [
//        "This    is    an",
//        "example  of text",
//        "justification.  "
//        ]
//

package April3;

import java.util.ArrayList;
import java.util.List;

public class Q1 {

    public static List<String> justifyText(String[] words, int L) {
        List<String> result = new ArrayList<>();
        List<String> line = new ArrayList<>();
        int lineLength = 0;

        for (String word : words) {
            if (lineLength + word.length() + line.size() > L) {
                // Distribute extra spaces evenly between words
                int numSpaces = L - lineLength;
                int spacesBetweenWords = line.size() > 1 ? numSpaces / (line.size() - 1) : 0;
                int extraSpaces = line.size() > 1 ? numSpaces % (line.size() - 1) : numSpaces;

                StringBuilder justifiedLine = new StringBuilder();
                for (int i = 0; i < line.size() - 1; i++) {
                    justifiedLine.append(line.get(i));
                    for (int j = 0; j < spacesBetweenWords; j++) {
                        justifiedLine.append(" ");
                    }
                    if (i < extraSpaces) {
                        justifiedLine.append(" ");
                    }
                }
                justifiedLine.append(line.get(line.size() - 1));  // Add the last word without extra spaces

                result.add(justifiedLine.toString());

                // Reset line variables for the next line
                line.clear();
                lineLength = 0;
            }

            line.add(word);
            lineLength += word.length();
        }

        // Format the last line (left justified)
        StringBuilder lastLine = new StringBuilder();
        for (int i = 0; i < line.size() - 1; i++) {
            lastLine.append(line.get(i)).append(" ");
        }
        lastLine.append(line.get(line.size() - 1));
        for (int i = 0; i < L - lastLine.length(); i++) {
            lastLine.append(" ");
        }
        result.add(lastLine.toString());

        return result;
    }

    public static void main(String[] args) {
        String[] A = {"This", "is", "an", "example", "of", "text", "justification."};
        int B = 16;
        List<String> justifiedText = justifyText(A, B);
        for (String line : justifiedText) {
            System.out.println(line);
        }
    }
}
