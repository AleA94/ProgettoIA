package core;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * La classe implementa l'interfaccia Graph<V,E> nello specifico di un grafo
 * sparso diretto rappresentato con liste di adiacenza. Abbiamo un ArrayList di
 * vertici del grafo, ad ognuno dei quali è associata, tramite un HashMap, una
 * lista di archi che sono connessi con quel nodo.
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
public class SparseGraph<V, E> implements Graph<V, E> {
	ArrayList<V> nodi;
	HashMap<V, ArrayList<E>> archi;
	int n;
	int m;

	/**
	 * cotruttore vuoto che inizializza: - l'ArrayList di vertici (nodi) -
	 * l'HashMap degli archi - il numero di vertici a 0 - il numero di archi a 0
	 */
	public SparseGraph() {
		nodi = new ArrayList<V>();
		archi = new HashMap<V, ArrayList<E>>();
		n = 0;
		m = 0;
	}

	/**
	 * aggiunge un vertice V al grafo il metodo aggiunge un elemento V
	 * all'ArrayList dei nodi, crea una lista di vicini associandola al vertice
	 * tramite l'HashMap e incrementa il numero di nodi del grafo.
	 * 
	 * @param vertex
	 *            vertice che si vuole aggiungere al grafo.
	 * @return valore booleano true in caso di inserimento corretto, dato che il
	 *         vertice non era già presente nel grafo, false altrimenti.
	 */
	@Override
	public boolean addVertex(V vertex) {
		if (!nodi.contains(vertex)) {
			nodi.add(vertex);
			n++;
			ArrayList<E> neighbors = new ArrayList<E>();
			archi.put(vertex, (ArrayList<E>) neighbors);
			return true;
		}

		return false;
	}

	/**
	 * aggiunge un arco orientato nel grafo. il metodo controlla se i due
	 * vertici forniti come parametri sono già presenti nel grafo, in caso
	 * contrario procede ad inserirli tramite il metodo addVertex ed infine,
	 * dopo aver creato un arco v1 -> v2 (uscente da v1 e entrante in v2), lo
	 * aggiunge alla lista degli adicenti (neighbors) del vertice v1.
	 * 
	 * @param v1
	 *            vertice da cui l'arco è uscente
	 * @param v2
	 *            vertice adiacente a v1
	 * @param info
	 *            informazioni riguardanti l'arco, possono anche essere null.
	 * @exception IllegalArgumentException
	 *                l'eccezzione viene sollevata in caso uno dei due nodi o
	 *                entrambi siano null.
	 * @return booleano, true in caso di arco aggiunto correttamente,
	 *         altrimenti, se già presente false.
	 */
	@Override
	public boolean addEdge(V v1, V v2, E info) {
		if (v1 == null || v2 == null)
			throw new IllegalArgumentException("il nodo non può essere null");
		if (nodi.contains(v1)) {
			if (!nodi.contains(v1))
				addVertex(v1);
			if (!nodi.contains(v2))
				addVertex(v2);
			Arco<V, E> a = new Arco<V, E>(info, v1, v2);
			ArrayList<Arco> neighbors = (ArrayList<Arco>) archi.get(v1);
			neighbors.add(a);
			m++;
			return true;
		}
		return false;
	}

	/**
	 * aggiunge un arco orientato pesato al grafo il metodo controlla se i due
	 * vertici forniti come parametri sono già presenti nel grafo, in caso
	 * contrario procede ad inserirli tramite il metodo addVertex ed infine,
	 * dopo aver creato un arco v1 -> v2 (uscente da v1 e entrante in v2) con
	 * peso weight, lo aggiunge alla lista degli adicenti (neighbors) del
	 * vertice v1.
	 * 
	 * @param v1
	 *            vertice da cui l'arco è uscente
	 * @param v2
	 *            vertice adiacente a v1
	 * @param info
	 *            informazioni riguardanti l'arco, possono anche essere null.
	 * @param weight
	 *            peso dell'arco.
	 * @exception IllegalArgumentException
	 *                l'eccezzione viene sollevata in caso uno dei due nodi o
	 *                entrambi siano null.
	 * @return booleano, true in caso di arco aggiunto correttamente,
	 *         altrimenti, se già presente false.
	 */
	@Override
	public boolean addEdge(V v1, V v2, double weight, E info) {
		if (v1 == null || v2 == null)
			throw new IllegalArgumentException("il nodo non può essere null");
		if (nodi.contains(v1)) {
			if (!nodi.contains(v1))
				addVertex(v1);
			if (!nodi.contains(v2))
				addVertex(v2);
			Arco<V, E> a = new Arco<V, E>(info, v1, v2, weight);

			ArrayList<Arco<V, E>> neighbors = (ArrayList<Arco<V, E>>) archi
					.get(v1);
			neighbors.add(a);
			m++;
			return true;
		}
		return false;
	}

	/**
	 * aggiunge un arco non orientato al grafo. il metodo crea un arco orientato
	 * uscente da v1 e entrante in v2 e un altro arco uscente da v2 e entrante
	 * in v1. si serve del metodo addEdge definito in precedenza. in questo modo
	 * l'arco verrà aggiunto sia alla lista di adiacenza di v2 che di v2 in modo
	 * che l'arco sia incidente su entrambi in nodi.
	 * 
	 * @param v1
	 *            vertice da cui l'arco è uscente
	 * @param v2
	 *            vertice adiacente a v1
	 * @param info
	 *            informazioni riguardanti l'arco, possono anche essere null.
	 * @return booleano, true in caso di arco aggiunto correttamente in entrambe
	 *         le liste di adiacenza, altrimenti, se già presente in entrambe le
	 *         liste di adiacenza false.
	 */
	@Override
	public boolean addUndirectedEdge(V v1, V v2, E info) {
		if (addEdge(v1, v2, info) || addEdge(v2, v1, info))
			return true;
		else
			return false;
	}

	/**
	 * aggiunge un arco pesato non orientato al grafo. il metodo crea un arco
	 * orientato uscente da v1 e entrante in v2 e un altro arco uscente da v2 e
	 * entrante in v1 entrambi con peso weight. si serve del metodo addEdge
	 * definito in precedenza. in questo modo l'arco verrà aggiunto sia alla
	 * lista di adiacenza di v2 che di v2 in modo che l'arco sia incidente su
	 * entrambi in nodi.
	 * 
	 * @param v1
	 *            vertice da cui l'arco è uscente
	 * @param v2
	 *            vertice adiacente a v1
	 * @param weight
	 *            peso dell'arco non oreintato (peso degli archi orientati in
	 *            entrambe le direzioni).
	 * @param info
	 *            informazioni riguardanti l'arco, possono anche essere null.
	 * @return booleano, true in caso di arco aggiunto correttamente in entrambe
	 *         le liste di adiacenza, altrimenti, se già presente in entrambe le
	 *         liste di adiacenza false.
	 */
	@Override
	public boolean addUndirectedEdge(V v1, V v2, double weight, E info) {
		addEdge(v1, v2, weight, info);
		addEdge(v2, v1, weight, info);
		return true;
	}

	/**
	 * controlla se un vertice,fornito come parametro, è presente nel grafo. il
	 * metodo invoca contains dell'ArrayList sulla lista dei vertici del grafo,
	 * se è presente resituisce true false altrimenti
	 * 
	 * @param vertex
	 *            vertice di cui si vuole sapere o meno la presenza all'interno
	 *            del grafo.
	 * @return booleano true in caso di vertice presente nel grafo, false
	 *         altrimenti
	 */
	@Override
	public boolean hasVertex(V vertex) {
		if (nodi.contains(vertex))
			return true;
		return false;
	}

	/**
	 * conrrolla se esiste un arco v1 -> v2. il metodo prima esegue un controllo
	 * all'interno della lista dei nodi del grafo, se entrambi i vertici sono
	 * presenti, procede al controllo all'interno della lista di adiacenti di v1
	 * per vedere se l'arco v1 -> v2 è presente.
	 * 
	 * @param v1
	 *            nodo uscente dell'arco cercato
	 * @param v2
	 *            nodo entrante dell'arco cercato
	 * @return booleano, true se l'arco v1 -> v2 fa parte del grafo, false
	 *         altrimenti
	 */
	@Override
	public boolean hasEdge(V v1, V v2) {
		if (nodi.contains(v1)) {
			if (nodi.contains(v2)) {
				ArrayList<Arco<V, E>> neighbors = (ArrayList<Arco<V, E>>) archi
						.get(v1);
				if (neighbors.contains(new Arco(v1, v2)))
					;
				return true;
			}
		}
		return false;
	}

	/**
	 * restituisce il peso di un arco source -> dest il metodo invoca la
	 * procedure getEdge fornendo come parametro i due vertici dati in input,
	 * una volta trovato l'arco ne restituisce il peso, in caso di un arco senza
	 * peso viene restituito 1.
	 * 
	 * @param source
	 *            nodo uscente (sorgente) dell'arco cercato.
	 * @param dest
	 *            nodo entrante(destinazione) dell'arco cercato
	 * @return peso dell'arco espresso in double.
	 */
	@Override
	public double getWeight(V source, V dest) {
		return getEdge(source, dest).getWeight();
	}

	/**
	 * restituisce la lista dei nodi presenti nel grafo
	 * 
	 * @return ArrayList contenente tutti i nodi inseriti, fino al momento
	 *         dell'invocazione, all'interno del grafo
	 */
	@Override
	public ArrayList<V> vertices() {
		return nodi;
	}

	/**
	 * restituisce la lista dei nodi adiacenti al nodo passato come parametro.
	 * grazie all'HashMap il metodo riesce a trovare la lista dei suoi adiacenti
	 * e viene restituita attraverso questo metodo.
	 * 
	 * @param vertex
	 *            vertice di cui si vuole ottenere la lista dei suoi nodi
	 *            adiacenti.
	 * @return lista dei noidi agiagenti al nodo fornito come parametro, in caso
	 *         non abbia nodi adiacenti la procedura restituisce null.
	 */
	@Override
	public ArrayList<V> neighbors(V vertex) {
		if (nodi.contains(vertex)) {
			ArrayList<V> neighbors = new ArrayList<V>();
			ArrayList<Arco> arch = (ArrayList<Arco>) archi.get(vertex);

			for (Arco a : arch)
				neighbors.add((V) a.fin);
			return neighbors;
		}
		return null;
	}

	/**
	 * restituisce l'arco source -> dest se presente nel grafo. il metodo
	 * ricerca all'interno della lista degli archi del nodo source, se esiste un
	 * arco che ha come sorgente source e destinazione dest
	 * 
	 * @param source
	 *            nodo uscente dell'arco source > dest
	 * @param dest
	 *            nodo entrante dell'arco source -> dest
	 * @return se presente arco source --> dest, altrimenti null
	 */
	public Arco getEdge(V source, V dest) {
		ArrayList<Arco> neighbors = (ArrayList<Arco>) archi.get(source);
		Arco find = new Arco(source, dest);
		for (Arco<V, E> a : neighbors) {
			if ((a.fin.equals(find.fin)) && (a.in.equals(find.in)))
				return a;
		}
		return null;
	}

	/**
	 * stampa la lista dei nodi del grafo la procedura scorre la lista dei nodi
	 * attraverso un for e per ogni nodo che incontra ne stampa il valore su
	 * console.
	 */
	public void printVertex() {
		for (V i : nodi)
			System.out.println(i);
	}

	/**
	 * stampa la lista di adiacenza del vertice passato come parametro; dopo
	 * aver ottento la lista di adiacenza del nodo passato come parametro,
	 * scorre tale seqenza con un for e stampa a video l'arco.
	 * 
	 * @param vertex
	 *            vertice di cui si vuole stampare la lista di adiacenza
	 */
	public void printNeighbors(V vertex) {
		ArrayList<Arco> neighbors = (ArrayList<Arco>) archi.get(vertex);
		for (Arco<V, E> a : neighbors)
			System.out.println("iniziale: " + a.in + " finale: " + a.fin
					+ " info: " + a.info);
	}

	/**
	 * crea un file .dot per esserre elaborato da graphviz. metodo che crea un
	 * file .dot con nome del file passato come parametro, che poi sarà laborato
	 * da graphviz per produrne un immagine del grafo.
	 * 
	 * @param GraphName
	 *            nome che si è deciso di dare al file .dot.
	 */
	public void toDot(String GraphName) throws IOException {
		String Graph = GraphName + ".dot";
		FileWriter outFile = new FileWriter(Graph, false);
		PrintWriter out = new PrintWriter(outFile);
		out.println("digraph " + GraphName + "{");
		for (V i : nodi) {
			ArrayList<Arco> neighbors = (ArrayList<Arco>) archi.get(i);
			for (Arco<V, E> a : neighbors) {
				out.println(a.in + " -> " + a.fin + ";");
			}
		}
		out.println("}");
		out.close();
	}
}
