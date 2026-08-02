class Solution {
    public boolean haveConflict(String[] event1, String[] event2) {
        String end1 = event1[1], start1 = event1[0];
        String end2 = event2[1], start2 = event2[0];
        return !(end1.compareTo(start2) < 0 || end2.compareTo(start1) < 0);
    }
}