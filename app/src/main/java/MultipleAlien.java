public class MultipleAlien extends Alien {
    private Alien[][] alienGrid;
    private boolean hasTransformed = false;

    public MultipleAlien(String imageName, String type, int rowIndex, int colIndex, Alien[][] grid) {
        super(imageName, type, rowIndex, colIndex);
        this.alienGrid = grid;
    }

    @Override
    public void act() {
        super.act();

        if (!hasTransformed && Math.random() < 0.1 && getRowIndex() > 0) { // 1% chance to transform
            for (int col = 0; col < alienGrid[0].length; col++) {
                Alien newAlien = new Alien("sprites/alien.gif", "alien", getRowIndex() - 1, col);
                alienGrid[getRowIndex() - 1][col] = newAlien;
            }
            setType("alien");
            hasTransformed = true;
        }
    }
}


