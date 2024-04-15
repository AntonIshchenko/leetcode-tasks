import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class KeysAndRooms {

    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        if (rooms.isEmpty() || rooms.get(0).isEmpty()) {
            return false;
        }

        Set<Integer> visited = new HashSet<>();
        visitRoom(0, rooms, visited);
        return visited.size() == rooms.size();
    }

    private void visitRoom(int roomNum, List<List<Integer>> rooms, Set<Integer> visited) {
        visited.add(roomNum);
        List<Integer> room = rooms.get(roomNum);
        for (Integer key : room) {
            if (!visited.contains(key))
                visitRoom(key, rooms, visited);
        }
    }

}
