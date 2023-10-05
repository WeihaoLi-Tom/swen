public class PowerfulAlien extends Alien {
    private int hitCount = 0;
    private static final int MAX_HIT_COUNT = 5;

    public PowerfulAlien(String imageName, String type, int rowIndex, int colIndex) {
        super(imageName, type, rowIndex, colIndex);
    }


    public void hit() {
        hitCount++;
        if (hitCount >= MAX_HIT_COUNT) {
            destroy();
        }
    }
}
