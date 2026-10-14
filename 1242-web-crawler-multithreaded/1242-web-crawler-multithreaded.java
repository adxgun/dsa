/**
 * // This is the HtmlParser's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface HtmlParser {
 *     public List<String> getUrls(String url) {}
 * }
 */
class Solution {
    public List<String> crawl(String startUrl, HtmlParser htmlParser) {
        String host = hostname(startUrl);
        Set<String> seen = ConcurrentHashMap.newKeySet();
        seen.add(startUrl);
        
        ExecutorService pool = Executors.newFixedThreadPool(16);
        CompletionService<List<String>> cs = new ExecutorCompletionService(pool);
        try {
            cs.submit(() -> fetchUrl(startUrl, seen, host, htmlParser));
            int pending = 1;

            while (pending > 0) {
                List<String> claimed = cs.take().get();
                pending--;
                
                for (String next : claimed) {
                    cs.submit(() -> fetchUrl(next, seen, host, htmlParser));
                    pending++;
                }
            }
        } catch (InterruptedException | ExecutionException ex) {
            throw new RuntimeException(ex);
        } finally {
            pool.shutdownNow();
        }

        return new ArrayList<>(seen);
    }

    private List<String> fetchUrl(String url, Set<String> seen, String host, HtmlParser htmlParser) {
        List<String> claimed = new ArrayList<>();
        for (String next : htmlParser.getUrls(url)) {
            if (hostname(next).equals(host) && !seen.contains(next)) {
                claimed.add(next);
                seen.add(next);
            }
        }

        return claimed;
    }

    private String hostname(String url) {
        int start = url.indexOf("//") + 2;
        int end = url.indexOf('/', start);
        return end == -1 ? url.substring(start) : url.substring(start, end);
    }
}