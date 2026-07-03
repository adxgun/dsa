class MyCalendar {
    // maps event start -> event end
    private final java.util.TreeMap<Integer, Integer> calendar;

    public MyCalendar() {
        calendar = new java.util.TreeMap<>();
    }

    public boolean book(int start, int end) {
        // nearest event starting at or before `start`
        Integer prevStart = calendar.floorKey(start);
        // its end must not reach past our start: prevEnd <= start is OK
        if (prevStart != null && calendar.get(prevStart) > start) {
            return false;
        }

        // nearest event starting at or after `start`
        Integer nextStart = calendar.ceilingKey(start);
        // our end must not reach into it: end <= nextStart is OK
        if (nextStart != null && nextStart < end) {
            return false;
        }

        calendar.put(start, end);   // no conflict -> book it
        return true;
    }
}