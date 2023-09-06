// SpaceShip.java
// Used for SpaceInvader

import ch.aplu.jgamegrid.*;
import java.awt.event.KeyEvent;
import java.awt.*;
import java.util.List;

public class SpaceShip extends Actor implements GGKeyListener
{
  private int nbShots = 0;
  private SpaceInvader spaceInvader;
  private boolean isAutoTesting = false;
  private List<String> controls = null;
  private int controlIndex = 0;
  private StringBuilder logResult = new StringBuilder();
  public SpaceShip(SpaceInvader spaceInvader)
  {
    super("sprites/spaceship.gif");
    this.spaceInvader = spaceInvader;
  }

  public void setTestingConditions(boolean isAutoTesting, List<String> controls) {
    this.isAutoTesting = isAutoTesting;
    this.controls = controls;
  }

  private void autoMove() {
    if (isAutoTesting) {
      if (controls != null && controlIndex < controls.size()) {
        String control = controls.get(controlIndex);
        Location next = null;

        switch(control) {
          case "L":
            next = getLocation().getAdjacentLocation(Location.WEST);
            moveTo(next);
            break;

          case "R":
            next = getLocation().getAdjacentLocation(Location.EAST);
            moveTo(next);
            break;

          case "F":
            Bomb bomb = new Bomb();
            gameGrid.addActor(bomb, getLocation());
            nbShots++;
            if (nbShots ==10 ) {
              spaceInvader.notifyAliensMoveFast();


            }
            break;
          case "E":
            spaceInvader.setIsGameOver(true);
            break;
        }
        controlIndex++;
      }
    }
  }

  public void act()
  {
    autoMove();
    Location location = getLocation();
    if (spaceInvader.getNumberOfActorsAt(location, Alien.class) > 0)
    {
      spaceInvader.removeAllActors();
      spaceInvader.addActor(new Actor("sprites/explosion2.gif"), location);
      spaceInvader.setIsGameOver(true);
      return;
    }
    if (spaceInvader.getNumberOfActors(Alien.class) == 0)
    {
      spaceInvader.getBg().drawText("Number of shots: " + nbShots, new Point(10, 30));
      spaceInvader.getBg().drawText("Game constructed with JGameGrid (www.aplu.ch)", new Point(10, 50));
      spaceInvader.addActor(new Actor("sprites/you_win.gif"), new Location(100, 60));
      spaceInvader.setIsGameOver(true);
      return;
    }
  }

  public boolean keyPressed(KeyEvent keyEvent)
  {
    Location next = null;
    switch (keyEvent.getKeyCode())
    {
      case KeyEvent.VK_LEFT:
        next = getLocation().getAdjacentLocation(Location.WEST);
        moveTo(next);
        break;

      case KeyEvent.VK_RIGHT:
        next = getLocation().getAdjacentLocation(Location.EAST);
        moveTo(next);
        break;

      case KeyEvent.VK_SPACE:
        Bomb bomb = new Bomb();
        gameGrid.addActor(bomb, getLocation());
        nbShots++;
        if (nbShots ==1 ) {
          spaceInvader.notifyAliensMoveFast();


        }

        break;
    }

    return false;
  }

  private void moveTo(Location location)
  {
    if (location.x > 10 && location.x < 190)
      setLocation(location);
  }

  @Override
  public boolean keyReleased(KeyEvent keyEvent) {
    return false;
  }
}

