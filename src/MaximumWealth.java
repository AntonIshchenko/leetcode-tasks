public class MaximumWealth {

    public int maximumWealth(int[][] accounts) {
        int [] sum = new int [accounts.length];
        for (int i = 0; i < accounts.length; i++) {
            for (int j = 0; j < accounts[0].length; j++) {
                sum[i] += accounts[i][j];
            }
        }

        int max = -1;
        for (int j : sum) {
            if (j > max) {
                max = j;
            }
        }
        return max;
    }
}
