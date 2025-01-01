class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> result = new ArrayList<>();

        if (s == null || s.length() == 0 || words == null || words.length == 0) {
            return result;
        }

        int wordLen = words[0].length();
        int totalLen = wordLen * words.length;
        Map<String, Integer> wordCount = new HashMap<>();

        for(String w : words) {
            wordCount.put(w, wordCount.getOrDefault(w, 0) + 1);
        }

        for (int offset = 0; offset < wordLen; offset++) {
            int left = offset, right = offset;
            Map<String, Integer> currentCount = new HashMap<>();
            
            int matched = 0;

            while(right + wordLen <= s.length()) {
                String chunk = s.substring(right, right + wordLen);
                right += wordLen;

                if (wordCount.containsKey(chunk)) {
                    currentCount.put(chunk, currentCount.getOrDefault(chunk, 0) + 1);

                    if (wordCount.get(chunk).equals(currentCount.get(chunk))) {
                        matched++;
                    }

                    while(currentCount.get(chunk) > wordCount.get(chunk)) {
                        String leftChunk = s.substring(left, left + wordLen);
                        currentCount.put(leftChunk, currentCount.getOrDefault(leftChunk, 0) - 1);

                        if (currentCount.get(leftChunk).equals(wordCount.get(leftChunk) - 1)) {
                            matched--;
                        }
                        left += wordLen;
                    }
                } else {
                    currentCount.clear();
                    matched = 0;
                    left = right;
                }

                if (matched == wordCount.size()) {
                    result.add(right - totalLen);
                }
            }
        }
        return result;
    }
}