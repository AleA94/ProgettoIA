package core;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * Algoritmo di Dijkstra classe che implementa la ricerca del cammino di peso
 * minimo all'interno di un grafo
 * 
 * @author Mauro
 * 
 * @param <V>
 *            tipo generico utilizzato per rappresentare i vertici (vertex) del
 *            grafo sparso.
 * @param <E>
 *            tipo generico utilizzato per rappresentare le informazioni degli
 *            archi (edges) del grafo sparso.
 */
public class MinPathDijkstra<V, E> {
	HeapPriorityQueue<V> q;
	HashMap<V, Double> dist;
	Map<V, V> padri;
	ArrayList<Object> path;

	/**
	 * Dijkstra modificato per trovare il cammino con il peso minimo da una
	 * sorgente ad una destinazione.
	 * 
	 * @param g
	 *            grafo su cui si vuole eseguire l'algoritmo di dijkstra
	 * @param s
	 *            nodo di partenza
	 * @param d
	 *            nodo destinazione
	 * @return sequenza di nodi che compongono il percorso di peso minimo da d a
	 *         s
	 */
	public ArrayList<Object> minPath(Graph<V, E> g, V s, V d) {

		q = new HeapPriorityQueue<V>(g.vertices().size());
		dist = new HashMap<V, Double>();
		padri = new HashMap<V, V>();
		path = new ArrayList<Object>();

		ArrayList<V> vertex = g.vertices();
		for (V x : vertex) {
			dist.put(x, Double.POSITIVE_INFINITY);
			padri.put(x, null);
		}
		padri.put(s, s);
		dist.put(s, 0.0);
		for (V x : vertex) {
			q.insert(x, dist.get(x));
		}

		while (!q.isEmpty()) {
			V u = q.extractfirst();
			for (V v : g.neighbors(u)) {
				double weight = g.getWeight(u, v);
				double distanceThrought = dist.get(u) + weight;// distanza del
																// padre + la
																// sua distanza
				if (distanceThrought < dist.get(v)) {// se il costo è inferiore
														// al nodo attuale
					dist.put(v, distanceThrought);
					padri.put(v, u);
					q.decreasePriority(v, dist.get(v));
				}
			}
		}
		V step;
		step = d;
		if (padri.get(d) == null)
			return null;
		path.add(step);
		while (padri.get(step) != null) {
			if (step.equals(s))
				break;
			step = padri.get(step);
			path.add(step);
		}
		Collections.reverse(path);
		return path;
	}

	/**
	 * Algoritmo di Dijkstra che calcola il percorso di peso minimo da un nodo
	 * sorgente a tutti gli altri nodi
	 * 
	 * @param g
	 *            grafo su cui si vuole eseguire l'algoritmo di dijkstra
	 * @param s
	 *            nodo di partenza
	 * @return sequenza di nodi che compongono il percorso di peso minimo da d a
	 *         s
	 */
	public Graph<V, E> minPath(Graph<V, E> g, V s) {
		q = new HeapPriorityQueue<V>(g.vertices().size());
		dist = new HashMap<V, Double>();
		padri = new HashMap<V, V>();
		path = new ArrayList<Object>();
		Graph<V, E> minPath = new SparseGraph<V, E>();

		ArrayList<V> vertex = g.vertices();
		for (V x : vertex) {
			dist.put(x, Double.POSITIVE_INFINITY);
			padri.put(x, null);
		}
		padri.put(s, s);
		dist.put(s, 0.0);
		for (V x : vertex) {
			q.insert(x, dist.get(x));
		}

		while (!q.isEmpty()) {
			V u = q.extractfirst();
			for (V v : g.neighbors(u)) {
				double weight = g.getWeight(u, v);
				double distanceThrought = dist.get(u) + weight;// distanza del
																// padre + la
																// sua distanza
				if (distanceThrought < dist.get(v)) {// se il costo è inferiore
														// al nodo attuale
					dist.put(v, distanceThrought);
					if (!(minPath.vertices().contains(v)))
						minPath.addVertex(v);
					if (!(minPath.vertices().contains(u)))
						minPath.addVertex(u);
					E info = null;
					minPath.addEdge(v, u, info);
					padri.put(v, u);
					q.decreasePriority(v, dist.get(v));
				}
			}
		}

		return minPath;
	}

	public ArrayList<V> nodiPozzo(Graph<V, E> g) {
		ArrayList<V> nodiPozzo = new ArrayList<V>();
		for (V v : g.vertices()) {
			if (g.neighbors(v) == null)
				nodiPozzo.add(v);
		}
		return nodiPozzo;
	}
}
