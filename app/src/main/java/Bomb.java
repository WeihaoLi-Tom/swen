// Bomb.java
// Used for SpaceInvader

import ch.aplu.jgamegrid.*;

import java.util.List;

public class Bomb extends Actor
{
  public Bomb()
  {
    super("sprites/bomb.gif");
  }

  public void reset()
  {
    setDirection(Location.NORTH);
  }

  public void act()
  {
    // Acts independently searching a possible target and bring it to explosion
    move();
    SpaceInvader spaceInvader = (SpaceInvader) gameGrid;
    List<Actor> actors = gameGrid.getActorsAt(getLocation(), Alien.class);
    if (actors.size() > 0) {
      for (Actor actor : actors) {
        Alien alien = (Alien) actor;
        alien.hit();  // 调用外星人的hit方法
      }
      spaceInvader.notifyAlienHit(actors);
      Explosion explosion = new Explosion();
      gameGrid.addActor(explosion, getLocation());
      removeSelf();
      return;
    }
    if (getLocation().y < 5)
      removeSelf();
  }
}
