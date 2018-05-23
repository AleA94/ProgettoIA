package GUI;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import GUI.ImageLoader;

public class MenuPanel extends JPanel {
	
	private static final long serialVersionUID = 1L;
	
	MainFrame f;
	Image bgM;
	int width;
	int height;
	private JButton start;
	private JButton exit;
	GamePanel gp;
	public MenuPanel(MainFrame mf) {
		f = mf;
		setLayout(null);
		bgM = ImageLoader.getBackgroundMenu().getScaledInstance(900, 700, 0);
		start = new JButton();
		start.setBounds(350, 200, 250, 75);
		start.setIcon(new ImageIcon(ImageLoader.getStart1().getScaledInstance(
				250, 35, 0)));
		start.setRolloverIcon(new ImageIcon(ImageLoader.getStart2()
				.getScaledInstance(250, 35, 0)));
		start.setBorderPainted(false);
		start.setFocusPainted(false);
		start.setContentAreaFilled(false);
		start.setVisible(true);
		this.add(start);

		exit = new JButton();
		exit.setBounds(350, 300, 250, 75);
		exit.setIcon(new ImageIcon(ImageLoader.getExit1().getScaledInstance(
				150, 30, 0)));
		exit.setRolloverIcon(new ImageIcon(ImageLoader.getExit2()
				.getScaledInstance(150, 30, 0)));
		exit.setBorderPainted(false);
		exit.setFocusPainted(false);
		exit.setContentAreaFilled(false);
		exit.setVisible(true);
		this.add(exit);

		start.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				GamePanel gp = new GamePanel(f);
				//gp = new GamePanel(f);
				gp.setFocusable(true);
				gp.requestFocus();
				f.setContentPane(gp);
				f.revalidate();
				//f.drawPanel("gamePanel");
				gp.setVisible(true);

			}
		});
		
		exit.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {

				System.exit(0);

			}
		});
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(bgM, 0, 0, null);
		g.drawImage(ImageLoader.getTitle().getScaledInstance(400, 50, 0), 400,
				50, null);
	}
}
