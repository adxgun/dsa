class Solution {
    public String toGoatLatin(String sentence) {
        List<Character> chars = Arrays.asList('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U');
        Set<Character> vowels = new HashSet<>(chars);
        
        String[] inputs = sentence.split(" ");
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < inputs.length; i++) {
            String next = inputs[i];
            if (vowels.contains(next.charAt(0))) {
                sb.append(next).
                    append("ma").
                    append("a".repeat(i + 1)).
                    append(" ");
            } else {
                char v = next.charAt(0);
                sb.append(next.substring(1, next.length())).
                    append(v).
                    append("ma").
                    append("a".repeat(i + 1)).
                    append(" ");
            }
        }

        return sb.toString().trim();
    }
}