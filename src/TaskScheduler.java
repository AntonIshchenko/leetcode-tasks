import javax.swing.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;
import java.util.TreeMap;
import java.util.TreeSet;

public class TaskScheduler {

    public int leastInterval(char[] tasks, int n) {
        if (tasks == null || tasks.length == 0) {
            return 0;
        }
        int[] numbers = new int[200];
        PriorityQueue<Integer> taskQueue = new PriorityQueue<>(Comparator.reverseOrder());
        for (Character c : tasks) {
            numbers[c]++;
        }
        for (Integer i : numbers) {
            if (i != 0)
                taskQueue.add(i);
        }

        LinkedList<ArrayList<Integer>> queue = new LinkedList<>();
        boolean inProgress = true;
        int time = 1;
        while (inProgress) {
            Integer tasksLeft = taskQueue.poll();
            if(tasksLeft != null) {
                tasksLeft--;
                if(tasksLeft != 0) {
                    queue.add(new ArrayList<>(Arrays.asList(tasksLeft, time + n)));
                }

            }
            // now task back to queue
            if(!queue.isEmpty()) {
                ArrayList<Integer> integers = queue.peekFirst();
                if(integers.get(1) <= time) {
                    taskQueue.add(integers.get(0));
                    queue.pollFirst();                }
            }
            if (queue.isEmpty() && taskQueue.isEmpty()) {
                inProgress = false;
            }
            time++;
        }

        return time-1;
    }

    public static void main(String[] args) {
        new TaskScheduler().leastInterval(new char[]{'A', 'C', 'A', 'B', 'D', 'B'}, 1);
    }
}
