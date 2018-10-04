import java.util.Random;

public class MineSweeper {

	private int mRows;
	private int mColumns;
	private int mMineCount;
	private int[][] mUnHiddenGrid;
	private int[][] mHiddenGrid;
	private boolean isGameFinished = false;

	public MineSweeper(int rows, int columns, int mineCount) {

		if(rows * columns <= mineCount) {
			throw new IllegalArgumentException("There are too many mines!");
		}

		mRows = rows;
		mColumns= columns;

		mUnHiddenGrid = new int[rows][columns];
		mHiddenGrid = new int[rows][columns];

		for(int i = 0; i < rows; i++) {
			for(int j = 0; j < columns; j++) {
				mHiddenGrid[i][j] = -1;
			}
		}

		mMineCount = mineCount;

		Random random = new Random();

		while(mineCount > 0) {

			int i = random.nextInt(rows);
			int j = random.nextInt(columns);

			if(mUnHiddenGrid[i][j] == 9) {
				continue;
			} else {
				mUnHiddenGrid[i][j] = 9;
				mineCount--;
			}


			for(int k = -1; k <= 1; k++) {
				for(int l = -1; l <= 1; l++) {
					if(k != 0 || l != 0) {

						int xCordinate = i + k;
						int yCordinate = j + l;

						boolean xCordinateOk = xCordinate >=0 && xCordinate < rows;
						boolean yCordinateOk = yCordinate >= 0 && yCordinate < columns;

						if(xCordinateOk && yCordinateOk) {

							int gridNum = mUnHiddenGrid[xCordinate][yCordinate];

							if(gridNum != 9) {
								mUnHiddenGrid[xCordinate][yCordinate] += 1;
							}

						}

					}
				}
			}

		}
		System.out.println("- MINE SWEEPER -");
		System.out.println();
		System.out.println(transformGrid());

	}

	@Override
	public String toString() {

		StringBuilder stringBuilder = new StringBuilder();

		for(int i = 0; i < mRows; i++) {
			for(int j = 0; j < mColumns; j++) {
				stringBuilder.append(mUnHiddenGrid[i][j] + " ");
			}
			stringBuilder.append(System.getProperty("line.separator"));
		}

		return stringBuilder.toString();
	}

	private String transformGrid() {
		StringBuilder transformedGrid = new StringBuilder();

		transformedGrid.append(" ");
		for(int r = 1; r <= mColumns; r++) {
			transformedGrid.append(" " + r);
		}
		transformedGrid.append(System.getProperty("line.separator"));

		for(int i = 0; i < mRows; i++) {
			transformedGrid.append(i + 1 + " ");
			for(int j = 0; j < mColumns; j++) {

				if(mHiddenGrid[i][j] == -1) {
					transformedGrid.append("- ");
				} else {
					transformedGrid.append(mHiddenGrid[i][j] + " ");
				}
			}
			transformedGrid.append(System.getProperty("line.separator"));
		}

		return transformedGrid.toString();

	}

	public void tryCoordinatesOf(int x, int y) {

		System.out.println("Try for (" + x-- + ", " + y-- + ")\n");

		if(isGameFinished) {
			System.out.println("No more try, game's finished.");
			return;
		}

		boolean isXCoordinateOk = x >= 0 && x < mRows;
		boolean isYCoordinateOk = y >= 0 && y < mColumns;

		if(isXCoordinateOk && isYCoordinateOk) {

			int gridNumber = mUnHiddenGrid[x][y];
			mHiddenGrid[x][y] = gridNumber;

			if(gridNumber == 9) {
				System.out.println("Bomb!! Game is over.");
				isGameFinished = true;
			}

			if(gridNumber == 0) {
				noMine(x, y);
			}


			System.out.println(transformGrid());

			int count = 0;

			for(int i = 0; i < mRows; i++) {
				for(int j = 0; j < mColumns; j++) {
					if(mHiddenGrid[i][j] == -1) {
						count++;
					}
				}
			}

			if(count <= mMineCount) {
				isGameFinished = true;
				System.out.println("Congrulations, You've found all the mines!");
				return;
			}

		} else {
			throw new IllegalArgumentException("Indexes are out of bound!");
		}
	}

	public void noMine(int i, int j) {

		mUnHiddenGrid[i][j] = -1;
		mHiddenGrid[i][j] = 0;

		for(int k = -1; k <= 1; k++) {
			for(int l = -1; l <= 1; l++) {
				if(k != 0 || l != 0) {

					int xCoordinate = i + k;
					int yCoordinate = j + l;

					boolean isXCoordianteOK = xCoordinate >=0 && xCoordinate < mRows;
					boolean isYCoordinateOK = yCoordinate >= 0 && yCoordinate < mColumns;

					if(isXCoordianteOK && isYCoordinateOK) {

						int gridNum = mUnHiddenGrid[xCoordinate][yCoordinate];

						if(gridNum == 0) {
							noMine(xCoordinate, yCoordinate);
						} else {
							if(gridNum != 9 && gridNum != -1) {
								mHiddenGrid[xCoordinate][yCoordinate] = gridNum;
							}
						}

					}

				}
			}
		}

	}

}
