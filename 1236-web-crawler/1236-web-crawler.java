/**
 * // This is the HtmlParser's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface HtmlParser {
 *     public List<String> getUrls(String url) {}
 * }
 */

class Solution {
    public List<String> crawl(String startUrl, HtmlParser htmlParser) {
        String hostname = hostname(startUrl);
        // System.out.println(hostname);
        Queue<String> queue = new ArrayDeque<>();
        Set<String> explored = new HashSet<>();
        queue.offer(startUrl);
        explored.add(startUrl);

        List<String> result = new ArrayList<>();
        while (!queue.isEmpty()) {
            String curUrl = queue.poll();
            result.add(curUrl);

            for (String next : htmlParser.getUrls(curUrl)) {
                if (hostname(next).equals(hostname) && !explored.contains(next)) {
                    queue.offer(next);
                    explored.add(next);
                }
            }
        }

        return result;
    }

    private String hostname(String url) {
        String[] parts = url.split("//");
        String upart = parts[1];
        int end = upart.indexOf('/');
        if (end == -1) return upart;
        return upart.substring(0, end);
    }
}