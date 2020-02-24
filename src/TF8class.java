
import javax.swing.JOptionPane;

public class TF8class {

	private int cols, rows;
	private int[][] grid;
	public int playerturn = 1;

	public TF8class(int r, int c) {

		this.cols = c;
		this.rows = r;
		grid = new int[r][c];

		spawnFirstBolcks();
		spawnFirstBolcks();

	}

	public boolean isValidMove(int a) {
		if (a == 0 || a == 1 || a == 2 || a == 3) {
			return true;
		}
		return false;
	}

	public boolean isInGrid(int row, int col) {
		if (row <= grid.length - 1 && col <= grid[0].length - 1 && col >= 0 && row >= 0) {
			return true;
		} else {
			return false;
		}
	}

	public boolean isInGrid(Location l) {
		return isInGrid(l.getRow(), l.getCol());
	}

	public boolean move(int dir) {
		if (isValidMove(dir) == false)
			return false;

		if (dir == 0) {
			moveleft();
			leftcollide();
			moveleft();
			spawnNewBlock();
		} else if (dir == 1) {
			moveright();
			rightcollide();
			moveright();
			spawnNewBlock();
		} else if (dir == 2) {
			moveup();
			upcollide();
			moveup();
			spawnNewBlock();
		} else if (dir == 3) {
			movedown();
			downcollide();
			movedown();
			spawnNewBlock();
		}
		checkForWinner();
		return true;
	}

	public void moveleft() {
		for (int r = 0; r < 4; r++) {
			for (int c = 3; c > 0; c--) {
				if (grid[r][c - 1] == 0) {
					grid[r][c - 1] = grid[r][c];
					grid[r][c] = 0;
				}
			}
		}
		for (int r = 0; r < 4; r++) {
			for (int c = 3; c > 0; c--) {
				if (grid[r][c - 1] == 0) {
					grid[r][c - 1] = grid[r][c];
					grid[r][c] = 0;
				}
			}
		}
		for (int r = 0; r < 4; r++) {
			for (int c = 3; c > 0; c--) {
				if (grid[r][c - 1] == 0) {
					grid[r][c - 1] = grid[r][c];
					grid[r][c] = 0;
				}
			}
		}
	}

	public void moveright() {
		for (int r = 0; r < 4; r++) {
			for (int c = 0; c < 3; c++) {
				if (grid[r][c + 1] == 0) {
					grid[r][c + 1] = grid[r][c];
					grid[r][c] = 0;
				}
			}
		}
		for (int r = 0; r < 4; r++) {
			for (int c = 0; c < 3; c++) {
				if (grid[r][c + 1] == 0) {
					grid[r][c + 1] = grid[r][c];
					grid[r][c] = 0;
				}
			}
		}
		for (int r = 0; r < 4; r++) {
			for (int c = 0; c < 3; c++) {
				if (grid[r][c + 1] == 0) {
					grid[r][c + 1] = grid[r][c];
					grid[r][c] = 0;
				}
			}
		}
	}

	public void moveup() {
		for (int r = 3; r > 0; r--) {
			for (int c = 3; c > -1; c--) {
				if (grid[r - 1][c] == 0) {
					grid[r - 1][c] = grid[r][c];
					grid[r][c] = 0;
				}
			}
		}
		for (int r = 3; r > 0; r--) {
			for (int c = 3; c > -1; c--) {
				if (grid[r - 1][c] == 0) {
					grid[r - 1][c] = grid[r][c];
					grid[r][c] = 0;
				}
			}
		}
		for (int r = 3; r > 0; r--) {
			for (int c = 3; c > -1; c--) {
				if (grid[r - 1][c] == 0) {
					grid[r - 1][c] = grid[r][c];
					grid[r][c] = 0;
				}
			}
		}
	}

	public void movedown() {
		for (int r = 0; r < 3; r++) {
			for (int c = 0; c < 4; c++) {
				if (grid[r + 1][c] == 0) {
					grid[r + 1][c] = grid[r][c];
					grid[r][c] = 0;
				}
			}
		}
		for (int r = 0; r < 3; r++) {
			for (int c = 0; c < 4; c++) {
				if (grid[r + 1][c] == 0) {
					grid[r + 1][c] = grid[r][c];
					grid[r][c] = 0;
				}
			}
		}
		for (int r = 0; r < 3; r++) {
			for (int c = 0; c < 4; c++) {
				if (grid[r + 1][c] == 0) {
					grid[r + 1][c] = grid[r][c];
					grid[r][c] = 0;
				}
			}
		}
	}

	public void spawnNewBlock() {
		if (isGridFull() == true) {
			return;
		} else {
			int randr = (int) (Math.random() * 4);
			int randc = (int) (Math.random() * 4);
			while (grid[randr][randc] != 0) {
				randr = (int) (Math.random() * 4);
				randc = (int) (Math.random() * 4);
			}

			grid[randr][randc] = 2;
		}
	}

	public void spawnFirstBolcks() {
		grid[(int) (Math.random() * 4)][(int) (Math.random() * 4)] = 2;
	}

	public boolean isInbounds(int row, int col) {
		if (row < 0)
			return false;
		if (row >= grid.length - 1)
			return false;
		if (col < 0)
			return false;
		if (col >= grid[0].length - 1)
			return false;

		return true;
	}

	public void leftcollide() {
		for (int r = 0; r < 4; r++) {
			for (int c = 1; c < 4; c++) {
				if (grid[r][c - 1] == grid[r][c]) {
					grid[r][c - 1] = grid[r][c - 1] * 2;
					grid[r][c] = 0;
				}
			}
		}
	}

	public void rightcollide() {
		for (int r = 0; r < 4; r++) {
			for (int c = 2; c > -1; c--) {
				if (grid[r][c + 1] == grid[r][c]) {
					grid[r][c + 1] = grid[r][c + 1] * 2;
					grid[r][c] = 0;
				}
			}
		}
	}

	public void upcollide() {
		for (int r = 3; r > 0; r--) {
			for (int c = 3; c > -1; c--) {
				if (grid[r - 1][c] == grid[r][c]) {
					grid[r - 1][c] = grid[r - 1][c] * 2;
					grid[r][c] = 0;
				}
			}
		}
	}

	public void downcollide() {
		for (int r = 0; r < 3; r++) {
			for (int c = 0; c < 4; c++) {
				if (grid[r + 1][c] == grid[r][c]) {
					grid[r + 1][c] = grid[r + 1][c] * 2;
					grid[r][c] = 0;
				}
			}
		}

	}

	public void checkForWinner() {
		if (Is2048() == true) {
			JOptionPane.showMessageDialog(null, " YOU WIN ");
			System.out.println(" YOU WIN ");
		} else if (isGridFull() == true && isNOTpossibleMove2() == true) {
			JOptionPane.showMessageDialog(null, " YOU LOOSE ");
			System.out.println(" YOU LOOSE ");
		}
	}

	public boolean Is2048() {
		for (int r = 0; r < grid.length; r++) {
			for (int c = 0; c < grid[0].length; c++) {
				if (grid[r][c] == 2048)
					return true;
			}
		}

		return false;
	}

	public boolean isGridFull() {
		for (int r = 0; r < grid.length; r++) {
			for (int c = 0; c < grid[0].length; c++) {
				if (grid[r][c] == 0) {
					return false;
				}
			}
		}
		return true;
	}

	public boolean isNOTpossibleMove2() {
		if (isPossMoveDown() == false && isPossMoveUp() == false && isPossMoveRight() == false
				&& isPossMoveLeft() == false) {
			return true;
		}
		return false;
	}

	public boolean isPossMoveUp() {
		for (int r = 3; r > 0; r--) {
			for (int c = 3; c > -1; c--) {
				if (grid[r][c] == grid[r - 1][c]) {
					return true;
				}
			}
		}
		return false;
	}

	public boolean isPossMoveDown() {
		for (int r = 0; r < 3; r++) {
			for (int c = 0; c < 4; c++) {
				if (grid[r][c] == grid[r + 1][c]) {
					return true;
				}
			}
		}
		return false;
	}

	public boolean isPossMoveRight() {
		for (int r = 0; r < 4; r++) {
			for (int c = 2; c > -1; c--) {
				if (grid[r][c] == grid[r][c + 1]) {
					return true;
				}
			}
		}
		return false;
	}

	public boolean isPossMoveLeft() {
		for (int r = 0; r < 4; r++) {
			for (int c = 1; c < 4; c++) {
				if (grid[r][c] == grid[r][c - 1]) {
					return true;
				}
			}
		}
		return false;
	}

	public int[][] getGrid() {
		return grid;
	}
}
