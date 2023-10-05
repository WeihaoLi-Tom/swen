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

        SpaceInvader game = (SpaceInvader) getGameGrid();
        if (!hasTransformed && Math.random() < 1 && getRowIndex() > 0 && !game.rowTransformed[getRowIndex()]) {
            int nbCols = alienGrid[0].length;
            Alien referenceAlien = this;
            for (int col = 0; col < nbCols; col++) {
                Alien newAlien = new Alien("sprites/alien.gif", "alien", getRowIndex() - 1, col);
                alienGrid[getRowIndex() - 1][col] = newAlien;
                Location currentLocation = getLocation();
                game.addActor(newAlien, new Location(currentLocation.x + (col - this.getColIndex()) * 10, currentLocation.y - 30));

                newAlien.setNbSteps(referenceAlien.getNbSteps());
                newAlien.setspeed(referenceAlien.getspeed());
                newAlien.setDirection(referenceAlien.getDirection());
            }
            setType("alien");
            hasTransformed = true;
            game.rowTransformed[getRowIndex()] = true;
        }
    }




}


