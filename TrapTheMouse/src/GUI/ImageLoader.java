package GUI;

import java.awt.Image;
import java.io.IOException;

import javax.imageio.ImageIO;

public class ImageLoader {
	
	public static Image mouse;
	public static Image wall;
	public static Image background;
	public static Image backgroundMenu;
	public static Image start1;
	public static Image start2;
	public static Image exit1;
	public static Image exit2;
	public static Image back1;
	public static Image back2;
	public static Image backgroundMouse;
	public static Image title;
	
	static {
		try {
			mouse = ImageIO.read(Thread.currentThread().getContextClassLoader().getResource("resources/img/mouse.png"));
			wall = ImageIO.read(Thread.currentThread().getContextClassLoader().getResource("resources/img/wall.png"));
			background = ImageIO.read(Thread.currentThread().getContextClassLoader().getResource("resources/img/background.png"));
			backgroundMenu = ImageIO.read(Thread.currentThread().getContextClassLoader().getResource("resources/img/backgroundMenu.jpeg"));
			start1 = ImageIO.read(Thread.currentThread().getContextClassLoader().getResource("resources/img/start1.png"));
			start2 = ImageIO.read(Thread.currentThread().getContextClassLoader().getResource("resources/img/start2.png"));
			backgroundMouse = ImageIO.read(Thread.currentThread().getContextClassLoader().getResource("resources/img/backgroundMouse.png"));
			title = ImageIO.read(Thread.currentThread().getContextClassLoader().getResource("resources/img/title.png"));
			exit1 = ImageIO.read(Thread.currentThread().getContextClassLoader().getResource("resources/img/exit1.png"));
			exit2 = ImageIO.read(Thread.currentThread().getContextClassLoader().getResource("resources/img/exit2.png"));
			back1 = ImageIO.read(Thread.currentThread().getContextClassLoader().getResource("resources/img/back1.png"));
			back2 = ImageIO.read(Thread.currentThread().getContextClassLoader().getResource("resources/img/back2.png"));
		} catch (final IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static Image getMouse() {
		return mouse;
	}

	public static void setMouse(Image mouse) {
		ImageLoader.mouse = mouse;
	}

	public static Image getWall() {
		return wall;
	}

	public static void setWall(Image wall) {
		ImageLoader.wall = wall;
	}

	public static Image getBackground() {
		return background;
	}

	public static void setBackground(Image background) {
		ImageLoader.background = background;
	}
	
	public static Image getBackgroundMenu() {
		return backgroundMenu;
	}

	public static void setBackgroundMenu(Image backgroundMenu) {
		ImageLoader.backgroundMenu = backgroundMenu;
	}

	public static Image getStart1() {
		return start1;
	}

	public static void setStart1(Image start1) {
		ImageLoader.start1 = start1;
	}

	public static Image getStart2() {
		return start2;
	}

	public static void setStart2(Image start2) {
		ImageLoader.start2 = start2;
	}


	public static Image getBackgroundMouse() {
		return backgroundMouse;
	}

	public static void setBackgroundMouse(Image backgroundMouse) {
		ImageLoader.backgroundMouse = backgroundMouse;
	}

	public static Image getTitle() {
		return title;
	}

	public static void setTitle(Image title) {
		ImageLoader.title = title;
	}

	public static Image getExit1() {
		return exit1;
	}

	public static void setExit1(Image exit1) {
		ImageLoader.exit1 = exit1;
	}

	public static Image getExit2() {
		return exit2;
	}

	public static void setExit2(Image exit2) {
		ImageLoader.exit2 = exit2;
	}

	public static Image getBack1() {
		return back1;
	}

	public static void setBack1(Image back1) {
		ImageLoader.back1 = back1;
	}

	public static Image getBack2() {
		return back2;
	}

	public static void setBack2(Image back2) {
		ImageLoader.back2 = back2;
	}
	
}
