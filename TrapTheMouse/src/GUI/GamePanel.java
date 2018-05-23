package GUI;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Random;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

import core.GameManager;
import core.Mouse;

public class GamePanel extends JPanel {

	private static final long serialVersionUID = 1L;
	
	GameManager gm;
	MainFrame f;
	public int matriceWall[][];
	boolean a = false;
	Image backgroundMouse;
	int mousey;
	int mousex;
	public Mouse m;
	private boolean turno = true;
	public int dim = 11;
	public GamePanel(MainFrame mf) {

		f = mf;
		gm = new GameManager(this);
		backgroundMouse = ImageLoader.getBackgroundMouse();
		matriceWall = new int[11][11];
		
		int cont = 0;
		for (int i = 0; i < dim; i++) {
			for (int j = 0; j < dim; j++){
				
				if(Math.random() < 0.10f)
					matriceWall[i][j] = 1;
				else
					matriceWall[i][j] = 0;
				
			}
			
		}
		m = new Mouse(5,5);
		matriceWall[m.getX()][m.getY()] = 2;

		addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent evt) {
				mousex = ((evt.getY() - 55) / 53);

				if (mousex % 2 == 0) {
					mousey = ((evt.getX() - 105) / 58);
				} else
					mousey = ((evt.getX() - 135) / 58);
				if(matriceWall[mousex][mousey] != 2){
					if (!turno && mousex >= 0 && mousey >= 0 && mousex < 11 && mousey < 11) {
						matriceWall[mousex][mousey] = 1;
						//System.out.println(mousex + " " + mousey);
						setTurno(true);
						//System.out.println(turno);
						repaint();
					}
				}
				else
					JOptionPane.showMessageDialog(null, "Errore");
			}
		});

		//System.out.println(turno);
		gm.start();
	}
	
	public void setTurno(boolean turno){
		this.turno = turno;
	}
	
	public boolean isTurno() {
		return turno;
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		this.setBackground(new Color(255, 247, 154));

		for (int i = 0; i < 11; i++) {// background
			for (int j = 0; j < 11; j++) {
				if (i % 2 == 0)
					g.drawImage(ImageLoader.getBackground(), 105 + j * 58,
							55 + i * 53, null);
				else
					g.drawImage(ImageLoader.getBackground(), 135 + j * 58,
							55 + i * 53, null);
			}
		}

		for (int i = 0; i < 11; i++) {// mouse
			for (int j = 0; j < 11; j++) {

				if (matriceWall[i][j] == 2) {
					if (i % 2 == 0)
						g.drawImage(ImageLoader.getMouse(), 105 + j * 58,
								55 + i * 53, null);
					else
						g.drawImage(ImageLoader.getMouse(), 135 + j * 58,
								55 + i * 53, null);
				}
			}
		}

		for (int i = 0; i < 11; i++) {// wall
			for (int j = 0; j < 11; j++) {
				if (matriceWall[i][j] == 1) {
					if (i % 2 == 0)
						g.drawImage(ImageLoader.getWall(), 105 + j * 58,
								15 + i * 53, null);
					else
						g.drawImage(ImageLoader.getWall(), 135 + j * 58,
								15 + i * 53, null);
				}
			}
		}
	}
}
