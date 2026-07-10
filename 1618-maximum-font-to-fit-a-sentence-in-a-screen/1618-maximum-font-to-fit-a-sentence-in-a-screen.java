/**
 * // This is the FontInfo's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface FontInfo {
 *     // Return the width of char ch when fontSize is used.
 *     public int getWidth(int fontSize, char ch) {}
 *     // Return Height of any char when fontSize is used.
 *     public int getHeight(int fontSize)
 * }
 */
class Solution {
    public int maxFont(String text, int w, int h, int[] fonts, FontInfo fontInfo) {
        int answer = -1, lo = 0, hi = fonts.length - 1;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (fits(text, fontInfo, fonts[mid], h, w)) {
                answer = fonts[mid];
                lo = mid + 1;
            } else hi = mid - 1;
        }
        return answer;
    }

    private boolean fits(String text, FontInfo info, int size, int h, int w) {
        if (info.getHeight(size) > h) return false;

        int width = 0;
        for (int i = 0; i < text.length(); i++) {
            width += info.getWidth(size, text.charAt(i));
            if (width > w) return false;
        }
        return true;
    }
}