package it.unibo.oop.lab06.generics1;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class DumbBreadthFirst<N> {
	private Graph<N> graph;
	private Queue<N> queue;
	private Map<N, N> parents;
	
	public DumbBreadthFirst(Graph<N> graph) {
		this.graph = graph;
		this.queue = new LinkedList<>();
		this.parents = new HashMap<>();
	}
	
	private boolean hasAlreadyBeenExplored(N node) {
		return this.parents.keySet().contains(node);
	}
	
	private void buildParentsMap(N target) {
		while (!this.queue.isEmpty()) {
			N nodeBeingExplored = this.queue.poll();
			for (N adjacentNode : graph.linkedNodes(nodeBeingExplored)) {
				if (!this.hasAlreadyBeenExplored(adjacentNode)) {
					this.parents.put(adjacentNode, nodeBeingExplored);
					if (!adjacentNode.equals(target)) {
						this.queue.add(adjacentNode);
					} else {
						this.queue.clear(); //break in disguise
					}	
				}	
			}
		}
	}
	
	private N getParentOf(N node) {
		return this.parents.get(node);
	}
	
	private List<N> traceBackToSource(N target) {
		List<N> path = new LinkedList<>();
		N parent = target;
		do {
			path.add(0, parent);
			parent = this.getParentOf(parent);
		} while (parent != null && !parent.equals(path.get(0)));
		return path;
	}
	
	public List<N> findSomePath(N source, N target) {
		this.queue.add(source);
		this.parents.put(source, source);
		this.buildParentsMap(target);
		return traceBackToSource(target);
	}
}
