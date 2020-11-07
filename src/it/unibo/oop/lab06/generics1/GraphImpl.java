package it.unibo.oop.lab06.generics1;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class GraphImpl<N> implements Graph<N> {
	
	private final Map<N, Set<N>> adjacentMap;
	
	public GraphImpl() {
		this.adjacentMap = new HashMap<>();
	}

	public void addNode(N node) {
		try {
			this.adjacentMap.putIfAbsent(node, new HashSet<>());
		} catch (NullPointerException e) {
			System.err.println("Cannot add a null node");
		}
	}

	public void addEdge(N source, N target) {
		if (this.adjacentMap.containsKey(source) && this.adjacentMap.containsKey(target)) {
			this.adjacentMap.get(source).add(target);
		}
	}

	public Set<N> nodeSet() {
		return Set.copyOf(this.adjacentMap.keySet());
	}

	public Set<N> linkedNodes(N node) {
		for (Map.Entry<N, Set<N>> entry : this.adjacentMap.entrySet()) {
			if (entry.getKey().equals(node)) {
				return Set.copyOf(entry.getValue());
			}
		}
		return Collections.emptySet();
	}

	public List<N> getPath(N source, N target) {
		return new DumbBreadthFirst<N>(this).findSomePath(source, target);
	}

}
