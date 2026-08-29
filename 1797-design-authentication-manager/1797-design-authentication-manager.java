class AuthenticationManager {

    private Map<String, Integer> tokens;
    private int ttl;
    
    public AuthenticationManager(int timeToLive) {
        tokens = new HashMap<>();
        ttl = timeToLive;
    }
    
    public void generate(String tokenId, int currentTime) {
        tokens.put(tokenId, currentTime + ttl);
    }
    
    public void renew(String tokenId, int currentTime) {
        Integer tokenTime = tokens.get(tokenId);
        if (tokenTime == null || currentTime - tokenTime >= 0) return;
        this.generate(tokenId, currentTime);
    }
    
    public int countUnexpiredTokens(int currentTime) {
        int count = 0;
        for (int t : tokens.values()) {
            if (currentTime - t < 0) count++;
        }
        return count;
    }
}

/**
 * Your AuthenticationManager object will be instantiated and called as such:
 * AuthenticationManager obj = new AuthenticationManager(timeToLive);
 * obj.generate(tokenId,currentTime);
 * obj.renew(tokenId,currentTime);
 * int param_3 = obj.countUnexpiredTokens(currentTime);
 */