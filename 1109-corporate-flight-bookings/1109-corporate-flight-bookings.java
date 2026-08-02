class Solution {
    public int[] corpFlightBookings(int[][] bookings, int n) {
        int[] flights = new int[n];
        for (int i = 1; i < n; i++) {
            flights[i] = flights[i] - flights[i-1];
        }

        for (int[] booking : bookings) {
            int start = booking[0] - 1;
            int end = booking[1] - 1;
            int seats = booking[2];

            flights[start] += seats;
            if (end + 1 < n) {
                flights[end + 1] -= seats;
            }
        }

        for (int i = 1; i < n; i++) {
            flights[i] = flights[i-1] + flights[i];
        }

        return flights;
    }
}