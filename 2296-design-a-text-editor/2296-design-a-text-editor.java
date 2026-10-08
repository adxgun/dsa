class TextEditor {

    private StringBuilder left = new StringBuilder();
    private StringBuilder right = new StringBuilder();

    public TextEditor() {
        
    }
    
    public void addText(String text) {
        left.append(text);
    }
    
    public int deleteText(int k) {
        int d = Math.min(k, left.length());
        left.setLength(left.length() - d);
        return d;
    }
    
    public String cursorLeft(int k) {
        while (k-- > 0 && left.length() > 0) {
            right.append(left.charAt(left.length() - 1));
            left.setLength(left.length() - 1);
        }

        return lastTen();
    }
    
    public String cursorRight(int k) {
        while (k-- > 0 && right.length() > 0) {
            left.append(right.charAt(right.length() - 1));
            right.setLength(right.length() - 1);
        }

        return lastTen();
    }

    private String lastTen() {
        return left.substring(Math.max(0, left.length() - 10));
    }
}

/**
 * Your TextEditor object will be instantiated and called as such:
 * TextEditor obj = new TextEditor();
 * obj.addText(text);
 * int param_2 = obj.deleteText(k);
 * String param_3 = obj.cursorLeft(k);
 * String param_4 = obj.cursorRight(k);
 */