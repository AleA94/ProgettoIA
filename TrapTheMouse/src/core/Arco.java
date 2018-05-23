package core;

/**
 * classe che implementa l'oggetto Arco di un grafo: - è formato da una coppia
 * di nodi del grafo (in, fin) - possiede un informazione del tipo generico E -
 * possiede un peso weight, se l'arco è senza peso gli verrà impostato il peso
 * di default a 1.
 * 
 * @author Mauro
 * 
 * @param <V>
 *            tipo generico usato per rappresentare i nodi del grafo.
 * @param <E>
 *            tipo generico usato per rappresentare un informazione del nodo.
 */
public class Arco<V, E> {
	E info;
	V in;
	V fin;
	double weight;

	/**
	 * cotruttore che prende come parametri 2 nodi, impostando l'info a null e
	 * il peso a 1.
	 * 
	 * @param in
	 *            nodo sorgente dell'arco
	 * @param fin
	 *            nodo destinazione dellìarco
	 */
	public Arco(V in, V fin) {
		this.info = null;
		this.in = in;
		this.fin = fin;
		this.weight = 1;
	}

	/**
	 * costruttore che crea un arco con informazione prende come parametri 2
	 * nodi e un informazione di tipo generica E. il peso sarà impostato a 1.
	 * 
	 * @param info
	 *            informazione riguardante l'arco
	 * @param in
	 *            nodo sorgente dell'arco
	 * @param fin
	 *            nodo destinazione dellìarco
	 */
	public Arco(E info, V in, V fin) {
		this.info = info;
		this.in = in;
		this.fin = fin;
		this.weight = 1;
	}

	/**
	 * costruttore che crea un arco con informazione e peso forniti come
	 * parametri. prende come parametri 2 nodi, il peso e l'onformazione ed
	 * andrà a impostarli a questi valori.
	 * 
	 * @param info
	 *            informazione riguardante l'arco
	 * @param in
	 *            nodo sorgente dell'arco
	 * @param fin
	 *            nodo destinazione dellìarco
	 * @param weight
	 *            peso che possiede l'arco.
	 */
	public Arco(E info, V in, V fin, double weight) {
		this.info = info;
		this.in = in;
		this.fin = fin;
		this.weight = weight;
	}

	/**
	 * restituisce il peso dell'arco passato come this.
	 * 
	 * @return peso dell'arco in valore double.
	 */
	double getWeight() {
		return weight;
	}
}