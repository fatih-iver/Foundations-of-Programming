import random

def createMineGrid(rows, columns, mines):

    # Initialize the game grid by filling it with zeros
    grid = [[0 for i in range(columns)] for j in range(rows)]

    emptyCells = rows * columns

    # Create a list to have linear time during randomization
    coordinates = list(range(emptyCells))

    # Remove an element from the list randomly - Linear Time
    for m in range(emptyCells - mines):
        emptyCells -= 1
        r = random.randint(0, emptyCells)
        del coordinates[r]

    # Place mines and right numbers for the adjacent cells to the mines
    for coordinate in coordinates:

        rowIndex = coordinate // columns
        columnIndex = coordinate % columns

        grid[rowIndex][columnIndex] = 9

        for i in range(-1, 2):
            for j in range(-1, 2):
                if i != 0 or j != 0:
                    adjacentRowIndex = rowIndex + i;
                    adjacentColumnIndex = columnIndex + j;

                    isValidRowIndex = adjacentRowIndex >= 0 and adjacentRowIndex < rows
                    isValidColumnIndex = adjacentColumnIndex >= 0 and adjacentColumnIndex < columns

                    if(isValidRowIndex and isValidColumnIndex):
                        if grid[adjacentRowIndex][adjacentColumnIndex] != 9:
                            grid[adjacentRowIndex][adjacentColumnIndex] += 1


    return grid
