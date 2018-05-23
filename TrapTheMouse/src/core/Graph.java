package core;

import java.io.IOException;
import java.util.ArrayList;

/**
 * interfaccia utilizzata per creare un grafo
 * 
 * @author Mauro
 * 
 * @param <V>
 *            tipo generico utilizzato per rappresentare i vertici (vertex) del
 *            grafo.
 * @param <E>
 *            tipo generico utilizzato per rappresentare le informazioni degli
 *            archi (edges) del grafo.
 */
public interface Graph<V, E> {
	/**
	 * viene aggiunto vertex al grafo, in caso di vertice già presente la
	 * procedura deve restituire false, altrmenti true.
	 * 
	 * @param vertex
	 *            vertice da inserire nel grafo
	 * @return true se inserito correttamente, altrimenti false (vertice già
	 *         presente).
	 */
	boolean addVertex(V vertex);

	/**
	 * aggiunge l'arco v1 -> v2 con informazione info e peso 1 nel grafo, se
	 * quello non ne fa già parte.
	 * 
	 * @param v1
	 *            vertice sorgente dell'arco
	 * @param v2
	 *            vertice destinazione dell'arco
	 * @param info
	 *            informazione sull'arco
	 * @return se inserito correttamente true, altrimenti se già presente false.
	 */
	boolean addEdge(V v1, V v2, E info);

	/**
	 * aggiunge l'arco v1 -> v2 con infromazione info e peso weight, se non già
	 * presente nel grafo. se i due veritci sono presenti nel grafo e l'arco
	 * viene inserito correttamente restituisce true
	 * 
	 * @param v1
	 *            vertice sorgente dell'arco (v1,v2)
	 * @param v2
	 *            vertice destinazione dell'arco (v1,v2)
	 * @param weight
	 *            peso dell'arco
	 * @param info
	 *            informazione sull'arco
	 * @return true se inserito crrettamente, altrimenti false.
	 */
	boolean addEdge(V v1, V v2, double weight, E info);

	/**
	 * aggiunge al grafo un arco non orientato v1 <-> v2 con informazione info e
	 * peso 1 se l'arco è già presente il metodo solleverà un eccezzione.
	 * 
	 * @param v1
	 *            un nodo dell'arco
	 * @param v2
	 *            altro nodo dell'arco
	 * @param info
	 *            informazione sull'arco
	 * @return ture se l'arco viene inserito correttamente, altrimenti false.
	 */
	boolean addUndirectedEdge(V v1, V v2, E info);

	/**
	 * aggiunge un arco non orientato v1 <-> v2 con informazione info e peso
	 * weight.
	 * 
	 * @param v1
	 *            un nodo dell'arco
	 * @param v2
	 *            altro nodo dell'arco
	 * @param info
	 *            informazione sull'arco
	 * @param weight
	 *            peso dell'arco
	 * @return true se l'arco è stato inserito correttamente, false altrimenti.
	 */
	boolean addUndirectedEdge(V v1, V v2, double weight, E info);

	/**
	 * controlla se vertex è presente nel grafo.
	 * 
	 * @param vertex
	 *            vertice di cui si vuole conoscere la presenza nel grafo.
	 * @return true se è contenuto nel grafo, false altrimenti.
	 */
	boolean hasVertex(V vertex);

	/**
	 * controlla se l'arco v1 -> v2 è presente nel grafo
	 * 
	 * @param v1
	 *            vertice uscente dell'arco
	 * @param v2
	 *            vertice entrante dell'arco
	 * @return true se l'arco è nel grafo, false altrimenti.
	 */
	boolean hasEdge(V v1, V v2);

	/**
	 * fornisce il peso dell'arco source -> dest
	 * 
	 * @param source
	 *            sorgente dell'arco
	 * @param dest
	 *            destinazione dell'arco
	 * @return valore del peso dell'arco espresso con il tipo double.
	 */
	double getWeight(V source, V dest);

	/**
	 * resitutisce i vertici del grafo sottoforma di un ArrayList
	 * 
	 * @return ArrayList di vertici del grafo
	 */
	ArrayList<V> vertices();

	/**
	 * restituisce i nodi che sono adiacenti al vertice vertex, sotto forma di
	 * un ArrayLis.
	 * 
	 * @param vertex
	 *            vertice di cui si vuole conoscere gli adiacenti.
	 * @return ArrayList con i vertici che sono vicini di vertex.
	 */
	ArrayList<V> neighbors(V vertex);

	/**
	 * crea la rappresentazione in formato dot language del grafo e ne crea un
	 * file che potrà essere elaborato da graphviz
	 * 
	 * @param string
	 *            path e nome del file che si vuole creare.
	 * @throws IOException
	 *             in caso non fosse possibile scivere il file
	 */
	void toDot(String string) throws IOException;
}
