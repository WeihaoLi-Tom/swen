// Alien.java
// Used for SpaceInvader

import ch.aplu.jgamegrid.*;

import java.util.List;

// Alien.java
// Used for SpaceInvader

import ch.aplu.jgamegrid.*;

import java.util.List;

public class Alien extends Actor
{
  private final int maxNbSteps = 16;
  private int nbSteps;
  private boolean isMoving = true;
  private boolean isAutoTesting;
  private List<String> movements;
  private int movementIndex = 0;
  private String type;
  private int rowIndex;
  private int colIndex;
  private int moveDistance = 1;

  public Alien(String imageName, String type, int rowIndex, int colIndex)
  {
    super(imageName);
    setSlowDown(7);
    this.type = type;
    this.rowIndex = rowIndex;
    this.colIndex = colIndex;
  }

  public void hit() {
    destroy();
  }


  public String getType() {
    return type;
  }

  public int getRowIndex() {
    return rowIndex;
  }

  public int getColIndex() {
    return colIndex;
  }

  public void reset()
  {
    nbSteps = 7;
  }

  public void setTestingConditions(boolean isAutoTesting, List<String> movements) {
    this.isAutoTesting = isAutoTesting;
    this.movements = movements;
  }

  private void checkMovements() {
    if (isAutoTesting) {
      if (movements != null && movementIndex < movements.size()) {
        String movement = movements.get(movementIndex);
        if (movement.equals("S")) {
          isMoving = false;
        } else if (movement.equals("M")) {
          isMoving = true;
        }
        movementIndex++;
      }
    }
  }

  public void act() {
    Location prevLocation = getLocation();  // 获取移动前的位置

    checkMovements();
    if (!isMoving) {
      return;
    }
    if (nbSteps < maxNbSteps) {
      move();
      nbSteps++;
    } else {
      nbSteps = 0;
      int angle;
      if (getDirection() == 0)
        angle = 90;
      else
        angle = -90;
      turn(angle);
      move();
      turn(angle);
    }

    Location newLocation = getLocation();


    int distanceMoved = Math.abs(newLocation.x - prevLocation.x) + Math.abs(newLocation.y - prevLocation.y);
    System.out.println("Alien of type " + type + " at position (" + getColIndex() + ", " + getRowIndex() + ") moved a distance of: " + distanceMoved);

    if (newLocation.y > 90)
      removeSelf();
  }


  public void destroy() {

    removeSelf();
  }
  public void setType(String type) {
    this.type = type;
  }

  public GameGrid getGameGrid() {
    return this.gameGrid;
  }
  public void move() {
    for (int i = 0; i < moveDistance; i++) {
      super.move();
    }
  }

  // 修改moveFaster()方法
  public void moveFaster() {
    moveDistance = 2;

  }


}