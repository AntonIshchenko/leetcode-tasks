import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class RightSideView {

    // node val < 100, nodes < 100;
    // null,
    public List<Integer> rightTreeView(TreeNode tree) {
        if (tree == null) {
            return new ArrayList<>();
        }

        List<Integer> result = new ArrayList<>();
        LinkedList<TreeNode> workingQueue = new LinkedList<>();

        workingQueue.add(tree);
//___________________________

        while (!workingQueue.isEmpty()) {
            int size = workingQueue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = workingQueue.poll();
                if (i == size - 1) {
                    result.add(node.val);
                }
                if (node.left != null) workingQueue.add(node.left);
                if (node.right != null) workingQueue.add(node.right);
            }
        }
//__________________________
        return result;
    }

}

