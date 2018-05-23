package core;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import DATA.Cell;
import DLV.AI;
import GUI.GamePanel;

public class GameManager extends Thread {

	GamePanel g;
	SparseGraph<String, String> grafo;
	AI ai;
	List<Cell> result;

	public GameManager(GamePanel g) {
		this.g = g;
		ai = new AI();
	}

	public void calcola(SparseGraph<String, String> grafo, int i, int j, int k,
			int h) {
		for (String nn : grafo.nodi) {
			String s[] = nn.split(" ");
			if (Integer.parseInt(s[0]) == k
					&& Integer.parseInt(s[1]) == h
					&& (Integer.parseInt(s[2]) == 0 || Integer.parseInt(s[2]) == 2)) {

				grafo.addEdge(i + " " + j + " " + g.matriceWall[i][j], (k)
						+ " " + h + " " + g.matriceWall[k][h], 1.0,
						g.matriceWall[i][j] + " " + g.matriceWall[k][h]);

				/*
				 * grafo.addEdge( (k) + " " + h + " " + g.matriceWall[k][h], i +
				 * " " + j + " " + g.matriceWall[i][j], 1.0, g.matriceWall[i][j]
				 * + " " + g.matriceWall[k][h]);
				 */
			}
			if (Integer.parseInt(s[0]) == k && Integer.parseInt(s[1]) == h
					&& (Integer.parseInt(s[2]) == 1)) {

				grafo.addEdge(i + " " + j + " " + g.matriceWall[i][j], (k)
						+ " " + h + " " + g.matriceWall[k][h], 100.0,
						g.matriceWall[i][j] + " " + g.matriceWall[k][h]);

				/*
				 * grafo.addEdge( (k) + " " + h + " " + g.matriceWall[k][h], i +
				 * " " + j + " " + g.matriceWall[i][j], 100000000000000000.0,
				 * g.matriceWall[i][j] + " " + g.matriceWall[k][h]);
				 */

			}
		}
	}

	public void CostruisciGrafo(int m[][], int dim) {
		grafo = new SparseGraph<String, String>();

		for (int i = 0; i < g.dim; i++) {
			for (int j = 0; j < g.dim; j++) {
				grafo.addVertex(i + " " + j + " " + g.matriceWall[i][j]);
			}
		}

		for (int i = 0; i < g.dim; i++) {
			for (int j = 0; j < g.dim; j++) {
				// if (g.matriceWall[i][j] != 1) {

				if (i % 2 != 0 && i != 0) {

					if (i + 1 < g.dim) {
						calcola(grafo, i, j, i + 1, j);
					}

					if (i + 1 < g.dim && j + 1 < g.dim) {
						calcola(grafo, i, j, i + 1, j + 1);
					}
					if (i - 1 >= 0)
						calcola(grafo, i, j, i - 1, j);

					if (j + 1 < g.dim)
						calcola(grafo, i, j, i, j + 1);

					if (j - 1 >= 0)
						calcola(grafo, i, j, i, j - 1);
					//
					if (i - 1 >= 0 && j + 1 < g.dim)
						calcola(grafo, i, j, i - 1, j + 1);
					//
				} else {

					if (i + 1 < g.dim)
						calcola(grafo, i, j, i + 1, j);
					//

					if (i + 1 < g.dim && j - 1 >= 0)
						calcola(grafo, i, j, i + 1, j - 1);
					//

					if (i - 1 >= 0)
						calcola(grafo, i, j, i - 1, j);
					//

					if (j + 1 < g.dim)
						calcola(grafo, i, j, i, j + 1);
					//
					if (j - 1 >= 0)
						calcola(grafo, i, j, i, j - 1);
					//

					if (i - 1 >= 0 && j - 1 >= 0)
						calcola(grafo, i, j, i - 1, j - 1);
					//
				}
			}
		}
	}

	@Override
	public void run() {

		while (true) {
			// System.out.println("sono qui" + g.isTurno());
			if (g.isTurno()) {

				CostruisciGrafo(g.matriceWall, g.dim);
				List<Object> path = g.m.findPath(grafo, g.matriceWall, g.m.x,
						g.m.y, 2);
				List<Object> paths = null;
				if (path.size() > 1) {
					paths = g.m.findPaths(grafo, g.matriceWall, g.m.x, g.m.y,
							2, path.size());
					/*
					 * if(paths.contains(path.get(path.size()-1)))
					 * paths.remove(path.get(path.size()-1));
					 */
				}

				List<Object> walls = new ArrayList<Object>();
				int count = 0;
				for (Object o : paths) {

					/*
					 * if (count <= path.size() / 2 + 1 && count >= path.size()
					 * / 2 - 1)
					 */
					walls.add(o);

					/*
					 * if (count == path.size() - 1) { count = 0; } else
					 * count++;
					 */

				}
				walls.spliterator();
				result = ai.mossa(g.matriceWall, walls, paths);

				g.matriceWall[result.get(0).getRow()][result.get(0).getColumn()] = 1;
				g.repaint();

				try {
					Thread.sleep(1000);
					g.setTurno(false);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}

			if (!g.isTurno()) {
				CostruisciGrafo(g.matriceWall, g.dim);
				g.matriceWall[g.m.getX()][g.m.getY()] = 0;
				g.m.updateMouse(grafo, g.matriceWall);
				g.matriceWall[g.m.getX()][g.m.getY()] = 2;
				// System.out.println(g.m.getX());

				g.repaint();
				if (this.g.m.x == 10 || this.g.m.y == 10 || this.g.m.x == 0
						|| this.g.m.y == 0) {
					JOptionPane.showMessageDialog(null, "Hai perso");
					System.exit(0);
				}
				try {
					Thread.sleep(1000);
					g.setTurno(true);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}

			}

		}
	}
}
