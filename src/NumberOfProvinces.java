import java.util.HashSet;
import java.util.Set;

public class NumberOfProvinces {

    public int findCircleNum(int[][] isConnected) {
        if (isConnected.length == 0) {
            return 0;
        }
        int numOfProvinces = 0;
        Set<Integer> visitedCities = new HashSet<>();

        for (int i = 0; i < isConnected.length; i++) {
            if (!visitedCities.contains(i)) {
                scanProvinces(i, isConnected, visitedCities);
                numOfProvinces++;
            }
        }

        return numOfProvinces;
    }

    private void scanProvinces(int i, int[][] isConnected, Set<Integer> visitedCities) {
        visitedCities.add(i);
        for (int j = 0; j < isConnected[i].length; j++) {
            if (!visitedCities.contains(j) && isConnected[i][j] == 1) {
                scanProvinces(j, isConnected, visitedCities);
            }
        }
    }
}
