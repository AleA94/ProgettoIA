package core;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

public class Mouse {
	int x, y;

	public Mouse(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public List<Object> findPath(SparseGraph<String, String> grafo, int[][] m,
			int x, int y, int p) {
		int min = Integer.MAX_VALUE;
		List<Object> path = new ArrayList<Object>();
		boolean muro = false;
		for (int i = 0; i < m.length; i++) {
			for (int j = 0; j < m.length; j++) {

				if (i == 0 || i == 10 || j == 0 || j == 10) {
					if (m[i][j] != 1) {
						MinPathDijkstra<String, String> topo = new MinPathDijkstra<String, String>();
						topo.minPath(grafo, x + " " + y + " " + p, i + " " + j
								+ " 0");
						for (int f = 0; f < topo.path.size(); f++) {
							String u[] = topo.path.get(f).toString().split(" ");
							if (u[2] == "1") {
								muro = true;
								break;
							}
						}
						if (topo.path.size() < min && !muro) {
							String z[] = topo.path.get(1).toString().split(" ");
							if (m[Integer.parseInt(z[0])][Integer
									.parseInt(z[1])] != 1) {
								min = topo.path.size();
								// path = new ArrayList<>();
								path = topo.path;
								//System.out.println(path);
							}
						} else
							muro = false;
					}
				}

			}
		}
		return path;
	}

	public List<Object> findPaths(SparseGraph<String, String> grafo, int[][] m,
			int x, int y, int p, int sizePath) {
		List<Object> paths = new ArrayList<Object>();
		int count = 0;
		boolean muro = false;
		for (int i = 0; i < m.length; i++) {
			for (int j = 0; j < m.length; j++) {

				if (i == 0 || i == 10 || j == 0 || j == 10) {
					if (m[i][j] != 1) {
						MinPathDijkstra<String, String> topo = new MinPathDijkstra<String, String>();
						topo.minPath(grafo, x + " " + y + " " + p, i + " " + j
								+ " 0");
						for (int f = 0; f < topo.path.size(); f++) {
							String u[] = topo.path.get(f).toString().split(" ");
							if (u[2] == "1") {
								muro = true;
								break;
							}
						}
						if (topo.path.size() == sizePath && !muro) {
							//System.out.println("paths : " + topo.path);
							String z[] = topo.path.get(1).toString().split(" ");
							if (m[Integer.parseInt(z[0])][Integer
									.parseInt(z[1])] != 1) {
								// for (int k = 1; k < topo.path.size(); k++) {
								if (topo.path.size() == 2)
									paths.add(count, topo.path.get((topo.path
											.size()) - 1));
								else if (topo.path.size() == 3)
									paths.add(count, topo.path.get((topo.path
											.size()) - 2));
								else
									paths.add(count, (topo.path.get(((topo.path
											.size()) - 1) / 2)));
								count++;
								//break;
								// }
							}
						} else
							muro = false;
					}
				}

			}
		}
		return paths;
	}

	public void updateMouse(SparseGraph<String, String> grafo, int[][] m) {
		String[] s = null;

		List<Object> path = findPath(grafo, m, this.x, this.y, 2);
		try {
			s = path.get(1).toString().split(" ");
			this.x = Integer.parseInt(s[0]);
			this.y = Integer.parseInt(s[1]);
			//System.out.println("x: " + this.x + " y: " + this.y);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Hai vinto");
			System.exit(0);
		}

	}

}
