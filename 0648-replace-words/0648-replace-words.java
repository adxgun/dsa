import java.util.StringJoiner;

class Solution {

    private final class Node {
        Node[] children = new Node[26];
        String word = "";
    }

    public String replaceWords(List<String> dictionary, String sentence) {
        Node root = new Node();
        for (String s : dictionary) {
            Node cur = root;
            for (char c : s.toCharArray()) {
                int i = c - 'a';
                if (cur.children[i] == null) cur.children[i] = new Node();
                cur = cur.children[i];
            }
            cur.word = s;
        }

        StringJoiner sj = new StringJoiner(" ");
        for (String w : sentence.split(" ")) {
            sj.add(walk(root, w));
        }

        return sj.toString();
    }

    private String walk(Node root, String w) {
        Node cur = root;
        for (char c : w.toCharArray()) {
            int i = c - 'a';
            cur = cur.children[i];
            if (cur == null) return w;
            if (!cur.word.isEmpty()) return cur.word;
        }

        return w;
    }
}

// "aadsfasf absbs bbab cadsfafs"