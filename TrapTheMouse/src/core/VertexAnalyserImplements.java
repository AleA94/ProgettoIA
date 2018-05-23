package core;

/**
 * classe che implementa l'interfaccia VertexAnalyser, contenente un metodo che
 * analizza il vertice passato come paramentro, in questa implementazione si è
 * deciso che il metodo stamperà a console il valore del verice.
 * 
 * @author Mauro
 * 
 * @param <V>
 *            tipo generico che rappresenta i nodi del grafo
 */
public class VertexAnalyserImplements<V> implements VertexAnalyser<V> {

	/**
	 * analizza il vertice vertex fornito come parametro, in questa
	 * implementazione verrà stampato il contenuto di vertex a console.
	 * 
	 * @param vertex
	 *            vertiche verrà analizzato dal metodo
	 */
	@Override
	public void analyse(V vertex) {
		System.out.println(vertex);
	}

}
