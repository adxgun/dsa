class Solution {
    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        Arrays.sort(products);
        List<List<String>> res = new ArrayList<>();
        String prefix = "";

        for (char c : searchWord.toCharArray()) {
            List<String> matches = new ArrayList<>();
            prefix += c;

            int start = lowerBound(products, prefix);
            for (int i = start; i < Math.min(start + 3, products.length); i++) {
                if (products[i].startsWith(prefix)) matches.add(products[i]);
                else break;
            }

            res.add(matches);
        }

        return res;
    }

    private int lowerBound(String[] products, String prefix) {
        int lo = 0, hi = products.length - 1;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (products[mid].compareTo(prefix) < 0) lo = mid + 1;
            else hi = mid - 1;
        }
        return lo;
    }
}