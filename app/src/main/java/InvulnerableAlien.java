public class InvulnerableAlien extends Alien {
    private int invulnerableCounter = 0;
    private static final int INVULNERABLE_TIME = 4;

    public InvulnerableAlien(String imageName, String type, int rowIndex, int colIndex) {
        super(imageName, "invulnerable", rowIndex, colIndex);
    }

    @Override
    public void hit() {
        if (invulnerableCounter > 0) {
            return;
        }
        super.hit();
    }

    @Override
    public void act() {
        super.act();
        if (invulnerableCounter > 0) {


            invulnerableCounter--;
            if (invulnerableCounter == 0) {
                setTransparency(1);
            }
        } else {

            if (Math.random() < 0.5) {
                invulnerableCounter = INVULNERABLE_TIME;
                setTransparency(0);
            }
        }
    }

    private void setTransparency(double value) {
// idk how
    }
}
