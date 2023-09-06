public class AlienFactory {
    public static Alien createAlien(String type, int rowIndex, int colIndex) {
        switch (type) {
            case "powerful":
                return new PowerfulAlien("sprites/powerful_alien.gif", type, rowIndex, colIndex);
            case "invulnerable":
                // 返回一个InvulnerableAlien实例
                // return new InvulnerableAlien("sprites/invulnerable_alien.gif", type, rowIndex, colIndex);
            case "multiple":
                // 返回一个MultipleAlien实例
                // return new MultipleAlien("sprites/multiple_alien.gif", type, rowIndex, colIndex);
            default:
                return new Alien("sprites/alien.gif", "alien", rowIndex, colIndex);
        }
    }
}

