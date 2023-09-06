public class AlienFactory {
    public static Alien createAlien(String imageName, String type, int rowIndex, int colIndex, Alien[][] grid) {
        switch (type) {
            case "powerful":
                return new PowerfulAlien(imageName, type, rowIndex, colIndex);
            case "invulnerable":
                return new InvulnerableAlien(imageName, type, rowIndex, colIndex);
            case "multiple":
                return new MultipleAlien(imageName, type, rowIndex, colIndex, grid);
            default:
                return new Alien(imageName, type, rowIndex, colIndex);
        }
    }
}

