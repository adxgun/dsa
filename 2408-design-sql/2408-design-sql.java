class SQL {
    
    private final Map<String, Table> tables = new HashMap<>();
    
    private final class Table {
        final int columns;
        int nextId = 1;
        final Map<Integer, List<String>> rows = new LinkedHashMap<>();

        public Table(int cols) {
            this.columns = cols;
        }
    }
    
    public SQL(List<String> names, List<Integer> columns) {
        for (int i = 0; i < names.size(); i++) {
            tables.put(names.get(i), new Table(columns.get(i)));
        }
    }
    
    public boolean ins(String name, List<String> row) {
        Table t = tables.get(name);
        if (t == null || t.columns != row.size()) return false;
        
        t.rows.put(t.nextId++, new ArrayList<>(row));
        return true;
    }
    
    public void rmv(String name, int rowId) {
        Table t = tables.get(name);
        if (t == null) return;

        t.rows.remove(rowId);
    }
    
    public String sel(String name, int rowId, int columnId) {
        Table t = tables.get(name);
        if (t == null) return "<null>";
        List<String> row = t.rows.get(rowId);
        if (row == null || columnId < 1 || columnId > row.size()) return "<null>";
        return row.get(columnId - 1);
    }
    
    public List<String> exp(String name) {
        List<String> res = new ArrayList<>();
        Table t = tables.get(name);
        if (t == null) return res;
        
        for (Map.Entry<Integer, List<String>> entry : t.rows.entrySet()) {
            res.add(entry.getKey() + "," + String.join(",", entry.getValue()));
        }
        return res;
    }
}

/**
 * Your SQL object will be instantiated and called as such:
 * SQL obj = new SQL(names, columns);
 * boolean param_1 = obj.ins(name,row);
 * obj.rmv(name,rowId);
 * String param_3 = obj.sel(name,rowId,columnId);
 * List<String> param_4 = obj.exp(name);
 */