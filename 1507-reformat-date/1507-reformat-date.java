class Solution {
    public String reformatDate(String date) {
        String[] segments = date.split(" ");
        List<String> sb = new ArrayList<>();
        sb.add(segments[2]);
        sb.add(format(month(segments[1])));
        sb.add(digit(segments[0]));
        return String.join("-", sb);
    }

    private String month(String s) {
        return switch (s) {
            case "Jan" -> "1";
            case "Feb" -> "2";
            case "Mar" -> "3";
            case "Apr" -> "4";
            case "May" -> "5";
            case "Jun" -> "6";
            case "Jul" -> "7";
            case "Aug" -> "8";
            case "Sep" -> "9";
            case "Oct" -> "10";
            case "Nov" -> "11";
            case "Dec" -> "12";
            default -> throw new IllegalArgumentException("Unknown month: " + s);
        };   // the switch expression ends with a semicolon, because it's part of the return statement
    }

    private String digit(String s) {
        StringBuilder sb = new StringBuilder();
        for (char ch : s.toCharArray()) {
            if (!Character.isDigit(ch)) break;
            sb.append(ch);
        }

        String res = sb.toString();
        return format(res);
    }

    private String format(String s) {
        return s.length() == 1 ? "0" + s : s;
    }
}