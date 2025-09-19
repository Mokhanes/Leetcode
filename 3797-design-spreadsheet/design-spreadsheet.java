class Spreadsheet {
    private int[][] grid;  // rows x 26

    public Spreadsheet(int rows) {
        grid = new int[rows][26]; // default 0
    }

    public void setCell(String cell, int value) {
        int[] pos = parseCell(cell);
        grid[pos[0]][pos[1]] = value;
    }

    public void resetCell(String cell) {
        int[] pos = parseCell(cell);
        grid[pos[0]][pos[1]] = 0;
    }

    public int getValue(String formula) {
        // formula looks like "=X+Y"
        String expr = formula.substring(1); // remove '='
        String[] parts = expr.split("\\+");
        int sum = 0;

        for (String p : parts) {
            if (Character.isLetter(p.charAt(0))) {
                int[] pos = parseCell(p);
                sum += grid[pos[0]][pos[1]];
            } else {
                sum += Integer.parseInt(p);
            }
        }
        return sum;
    }

    // helper: convert "B12" -> [rowIndex, colIndex]
    private int[] parseCell(String cell) {
        int col = cell.charAt(0) - 'A';
        int row = Integer.parseInt(cell.substring(1)) - 1;
        return new int[]{row, col};
    }
}
