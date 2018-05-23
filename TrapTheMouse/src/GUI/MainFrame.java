package GUI;

import java.awt.Dimension;
import java.awt.Toolkit;
import javax.swing.JFrame;

import DLV.AI;

@SuppressWarnings("serial")
public class MainFrame extends JFrame{
	
	MenuPanel mp;
	GamePanel gp;
	
	public MainFrame() {
		mp = new MenuPanel(this);
		//gp = new GamePanel (this);
		this.setUndecorated(true);
		this.toFront();
		drawPanel("menuPanel");
		this.setLayout(null);
		Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
		this.setPreferredSize(new Dimension(900,700));
		this.setLocation((int) d.getHeight()/4,(int) d.getWidth()/55);
		this.pack();
		this.revalidate();
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	public void drawPanel(String panel) {
		
		switch (panel) {
		case "menuPanel":
			gp = null;
			this.setContentPane(mp);
			break;
		case "gamePanel":
			//gp = new GamePanel(this);
			gp.setFocusable(true);
			gp.requestFocus();
			this.setContentPane(gp);
			this.revalidate();
			break;
		}
		pack();
	}
	
	public static void main(String[] args) {
		final MainFrame mf = new MainFrame();
		mf.setVisible(true);
	}
}
