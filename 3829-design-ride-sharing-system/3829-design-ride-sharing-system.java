class RideSharingSystem {

    private final Queue<Integer> drivers = new ArrayDeque<>();
    private final LinkedHashSet<Integer> riders = new LinkedHashSet<>();
    
    public RideSharingSystem() {
        
    }
    
    public void addRider(int riderId) {
        riders.add(riderId);
    }
    
    public void addDriver(int driverId) {
        drivers.offer(driverId);   
    }
    
    public int[] matchDriverWithRider() {
        if (drivers.size() == 0 || riders.size() == 0) return new int[]{-1, -1};
        Iterator<Integer> it = riders.iterator();
        int rider = it.next();
        it.remove();
        return new int[]{drivers.poll(), rider};
    }
    
    public void cancelRider(int riderId) {
        riders.remove(riderId);
    }
}

/**
 * Your RideSharingSystem object will be instantiated and called as such:
 * RideSharingSystem obj = new RideSharingSystem();
 * obj.addRider(riderId);
 * obj.addDriver(driverId);
 * int[] param_3 = obj.matchDriverWithRider();
 * obj.cancelRider(riderId);
 */