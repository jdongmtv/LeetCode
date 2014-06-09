import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;


public class TreeLevel {

    public ArrayList<ArrayList<Integer>> levelOrder(TreeNode root) {
        ArrayList<ArrayList<Integer>> results = new ArrayList<ArrayList<Integer>>();
        if(root == null)
            return results;
        LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
        ArrayList<Integer> result = new ArrayList<Integer>();
        queue.add(root);
        int size = queue.size();
        while(!queue.isEmpty()) {
            TreeNode tmp = queue.removeFirst();
            result.add(tmp.val);
            --size;
            if(tmp.left!=null)
                queue.add(tmp.left);
            if(tmp.right!=null)
                queue.add(tmp.right);
            if(size == 0) {
                results.add(result);
                result = new ArrayList<Integer>();
                size = queue.size();
            }
        }
        return results;
    }
    
    public ArrayList<ArrayList<Integer>> zigzagLevelOrder(TreeNode root) {
        ArrayList<ArrayList<Integer>> results = new ArrayList<ArrayList<Integer>>();
        if(root == null)
            return results;
        LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
        ArrayList<Integer> result = new ArrayList<Integer>();
        queue.add(root);
        boolean reverse =false;
        int size = queue.size();
        while(!queue.isEmpty()) {
            TreeNode tmp = queue.removeFirst();
            result.add(tmp.val);
            --size;
            if(tmp.left!=null)
                queue.add(tmp.left);
            if(tmp.right!=null)
                queue.add(tmp.right);
            if(size == 0) {
            	if(reverse)
            		Collections.reverse(result);
            	reverse = !reverse;
                results.add(result);
                result = new ArrayList<Integer>();
                size = queue.size();
            }
        }
        return results;
    }
    
    public ArrayList<ArrayList<Integer>> levelOrderBottom(TreeNode root) {
        ArrayList<ArrayList<Integer>> results = new ArrayList<ArrayList<Integer>>();
        if(root == null)
            return results;
        LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
        ArrayList<Integer> result = new ArrayList<Integer>();
        queue.add(root);
        int size = queue.size();
        while(!queue.isEmpty()) {
            TreeNode tmp = queue.removeFirst();
            result.add(tmp.val);
            --size;
            if(tmp.left!=null)
                queue.add(tmp.left);
            if(tmp.right!=null)
                queue.add(tmp.right);
            if(size == 0) {
                results.add(result);
                result = new ArrayList<Integer>();
                size = queue.size();
            }
        }
        Collections.reverse(results);
        return results;
    }
    
}
