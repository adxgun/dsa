class Solution {
    public int getWinner(int[] arr, int k) {
        int champ = arr[0], wins = 0;

        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > champ) {
                champ = arr[i];
                wins = 1;
            } else wins++;

            if (wins == k) return champ;
        }

        return champ;
    }
}