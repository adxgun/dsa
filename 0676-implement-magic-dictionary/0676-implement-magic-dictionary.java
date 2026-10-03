class MagicDictionary {

    private String[] dictionary;
    public MagicDictionary() {
    }
    
    public void buildDict(String[] dictionary) {
        this.dictionary = dictionary;
    }
    
    public boolean search(String searchWord) {
        return bf(searchWord);
    }

    private boolean bf(String w) {
        for (String dict : dictionary) {
            if (isMagic(dict, w)) return true;
        }
        return false;
    }

    private boolean isMagic(String a, String b) {
        if (a.length() != b.length() || a.equals(b)) return false;
        
        int diff = 0;
        for (int i = 0; i < a.length(); i++) {
            if (a.charAt(i) != b.charAt(i)) {
                diff++;
                if (diff > 1) return false;
            }
        }
        return true;
    }
}

/**
 * Your MagicDictionary object will be instantiated and called as such:
 * MagicDictionary obj = new MagicDictionary();
 * obj.buildDict(dictionary);
 * boolean param_2 = obj.search(searchWord);
 */