package core;

/**
 * interfaccia che che permette l'implementazione di classi che analizzano i
 * nodi di un grafo durante la visita
 * 
 * @author Mauro
 * 
 * @param <V>
 *            tipo generico che rappresenta i nodi del grafo
 */
public interface VertexAnalyser<V> {
	/**
	 * metodo che effettua un analisi sul vertice vertex passato come parametro
	 * 
	 * @param vertex
	 *            vertice che si vuole analizzare.
	 */
	void analyse(V vertex);
}
