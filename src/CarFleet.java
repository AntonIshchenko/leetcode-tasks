import java.util.HashSet;
import java.util.Set;

public class CarFleet {

    public int carFleet(int target, int[] position, int[] speed) {
        Set<Integer> resultSet = new HashSet<>();

        for (int i = 0; i < position.length; i++) {
            resultSet.add(position[i] + speed[i]);
        }
        return resultSet.size();
    }
}

