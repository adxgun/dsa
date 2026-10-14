class Solution {
    public List<String> alertNames(String[] keyName, String[] keyTime) {
        Map<String, List<Integer>> alerts = new HashMap<>();
        for (int i = 0; i < keyName.length; i++) {
            alerts.computeIfAbsent(keyName[i], (k) -> new ArrayList<>()).add(minutes(keyTime[i]));
        }

        List<String> res = new ArrayList<>();
        for (Map.Entry<String, List<Integer>> entry : alerts.entrySet()) {
            List<Integer> row = entry.getValue();
            if (row.size() < 3) continue;
            Collections.sort(row);

            for (int i = 2; i < row.size(); i++) {
                if (row.get(i) - row.get(i - 2) <= 60) {
                    res.add(entry.getKey());
                    break;
                }
            }
        }

        Collections.sort(res);
        return res;
    }

    private int minutes(String t) {
        String[] parts = t.split(":");
        return Integer.parseInt(parts[0]) * 60 + Integer.parseInt(parts[1]);
    }
}