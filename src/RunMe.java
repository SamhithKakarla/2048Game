import processing.core.*;

public class RunMe extends PApplet {
	private static final int LEFT_DIR = 0;
	private static final int RIGHT_DIR = 1;
	private static final int DOWN_DIR = 3;
	private static final int UP_DIR = 2;
	int c;
	TF8class game;
	Display display;

	public void setup() {
		size(800, 800); // set the size of the screen.

		// Create a game object
		game = new TF8class(4, 4);

		// Create the display
		// parameters: (10,10) is upper left of display
		// (300, 300) is the width and height
		display = new Display(this, 10, 10, 780, 780);

		display.setColor(2, 0xFF3399FF); // SET COLORS FOR PLAYER 1 & 2
		display.setColor(4, 0xFFffe508);
		display.setColor(8, 0xFF704100);
		display.setColor(16, 0xFF00FFFF);
		display.setColor(32, 0xFFFF00FF);
		display.setColor(64, 0xFF006400);
		display.setColor(128, 0xFFFF0000);
		display.setColor(256, 0xFF7FFF00);
		display.setColor(512, 0xFFFAFAFA);
		display.setColor(1024, 0xFF8B008B);
		display.setColor(2048, 0xFFf0a844);

		// You can use images instead if you'd like.
		// d.setImage(1, "c:/data/ball.jpg");
		// d.setImage(2, "c:/data/cone.jpg");

		display.initializeWithGame(game);
		c = 0;
	}

	@Override
	public void draw() {
		background(200);

		display.drawGrid(game.getGrid()); // display the game
	}

	public void keyPressed() {
		if (key == 'w') {
			game.move(UP_DIR);
		} else if (key == 'a') {
			game.move(LEFT_DIR);
		} else if (key == 's') {
			game.move(DOWN_DIR);
		} else if (key == 'd') {
			game.move(RIGHT_DIR);
		} else if (key == CODED) {
			if (keyCode == UP) {
				game.move(UP_DIR);
			} else if (keyCode == LEFT) {
				game.move(LEFT_DIR);
			} else if (keyCode == DOWN) {
				game.move(DOWN_DIR);
			} else if (keyCode == RIGHT) {
				game.move(RIGHT_DIR);
			}
		}
	}

	// main method to launch this Processing sketch from computer
	public static void main(String[] args) {
		PApplet.main(new String[] { "RunMe" });
	}
}
