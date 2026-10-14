class Solution {

    public List<List<String>> findDuplicate(String[] paths) {
        Map<String, List<String>> files = parse(paths);
        List<List<String>> result = new ArrayList<>();
        
        for (Map.Entry<String, List<String>> entry : files.entrySet()) {
            if (entry.getValue().size() > 1) {
                result.add(new ArrayList<>(entry.getValue()));
            }
        }

        return result;
    }

    private Map<String, List<String>> parse(String[] paths) {
        Map<String, List<String>> files = new HashMap<>();
        for (String path : paths) {
            String[] parts = path.split(" ");
            String root = parts[0];
            for (int i = 1; i < parts.length; i++) {
                String name = parts[i];
                String content = name.substring(name.indexOf('(') + 1, name.indexOf(')'));
                String full = root + "/" + name.substring(0, name.indexOf('('));
                files.computeIfAbsent(content, (j) -> new ArrayList<>()).add(full);
            }
        }

        return files;
    }
}