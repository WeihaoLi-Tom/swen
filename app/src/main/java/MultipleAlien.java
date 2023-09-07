import ch.aplu.jgamegrid.Location;
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

        if (!hasTransformed && Math.random() < 1 && getRowIndex() > 0) {
            SpaceInvader game = (SpaceInvader) getGameGrid();
            int nbCols = alienGrid[0].length; // 获取列数
            for (int col = 0; col < nbCols; col++) {
                Alien newAlien = new Alien("sprites/alien.gif", "alien", getRowIndex() - 1, col);
                alienGrid[getRowIndex() - 1][col] = newAlien;
                Location currentLocation = getLocation(); // 获取当前位置
                game.addActor(newAlien, new Location(currentLocation.x + (col - this.getColIndex()) * 10, currentLocation.y - 10)); // 根据当前位置和列的差异来计算新的位置
            }
            setType("alien");
            hasTransformed = true;
        }


    }
}


