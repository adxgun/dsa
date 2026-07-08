class Solution {
    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        Arrays.sort(products);
        int N = searchWord.length();
        List<List<String>> res = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            List<String> matches = new ArrayList<>();
            String sub = searchWord.substring(0, i + 1);
            for (String product : products) {
                if (product.startsWith(sub) && matches.size() < 3) {
                    matches.add(product);
                }
            }

            res.add(matches);
        }

        return res;
    }
}