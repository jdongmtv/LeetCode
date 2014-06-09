import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class Graph {
	
	 static class UndirectedGraphNode {
		 int label;
		 List<UndirectedGraphNode> neighbors;
		 UndirectedGraphNode(int x) { 
			 label = x; 
			 neighbors = new ArrayList<UndirectedGraphNode>(); 
		 }
	  }
	   
	  public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
		   if(node == null)
			   return null;
		   UndirectedGraphNode first = new UndirectedGraphNode(node.label);
		   Map<UndirectedGraphNode, UndirectedGraphNode> map = new HashMap<>();
		   map.put(node, first);
		   Queue<UndirectedGraphNode> queue = new LinkedList<>();
		   queue.add(node);
		   while(!queue.isEmpty()) {
			   UndirectedGraphNode graphNode = queue.poll();
			   for(UndirectedGraphNode undirectedGraphNode : graphNode.neighbors) {
				   if(!map.containsKey(undirectedGraphNode)) {
					   UndirectedGraphNode replicate = new UndirectedGraphNode(undirectedGraphNode.label); 
					   map.put(undirectedGraphNode, replicate);
					   queue.add(undirectedGraphNode);
				   } 
				   map.get(graphNode).neighbors.add(map.get(undirectedGraphNode));
			   }
		   }
		   return first;
	  }
	  
}
