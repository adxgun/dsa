class UndergroundSystem {

    private Map<String, long[]> routes;
    private Map<Integer, Object[]> checkIns;
    public UndergroundSystem() {
        routes = new HashMap<>();
        checkIns = new HashMap<>();
    }
    
    public void checkIn(int id, String stationName, int t) {
        checkIns.put(id, new Object[]{stationName, t});
    }
    
    public void checkOut(int id, String stationName, int t) {
        Object[] entry = checkIns.remove(id);
        String startStation = (String) entry[0];
        int startTime = (int) entry[1];

        String key = startStation + "," + stationName;
        long[] stats = routes.computeIfAbsent(key, (k) -> new long[2]);
        stats[0] += (t - startTime);
        stats[1] += 1;
    }
    
    public double getAverageTime(String startStation, String endStation) {
        long[] stats = routes.get(startStation + "," + endStation);
        return ((double) stats[0] / stats[1]);
    }
}

/**
 * Your UndergroundSystem object will be instantiated and called as such:
 * UndergroundSystem obj = new UndergroundSystem();
 * obj.checkIn(id,stationName,t);
 * obj.checkOut(id,stationName,t);
 * double param_3 = obj.getAverageTime(startStation,endStation);
 */