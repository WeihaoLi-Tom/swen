import java.util.Properties;
import java.util.ArrayList;

public class Driver {
    public static final String DEFAULT_PROPERTIES_PATH = "properties/game2.properties";

    public static void main(String[] args) {
        String propertiesPath = DEFAULT_PROPERTIES_PATH;
        if (args.length > 0) {
            propertiesPath = args[0];
        }
        final Properties properties = PropertiesLoader.loadPropertiesFile(propertiesPath);

        ArrayList<AlienGridLocation> powerfulAlienLocations = convertFromProperty(properties, "Powerful.locations");
        ArrayList<AlienGridLocation> invulnerableAlienLocations = convertFromProperty(properties, "Invulnerable.locations");
        ArrayList<AlienGridLocation> multipleAlienLocations = convertFromProperty(properties, "Multiple.locations");

        // Pass the properties object as the first argument
        String logResult = new SpaceInvader(properties, powerfulAlienLocations, invulnerableAlienLocations, multipleAlienLocations).runApp(true);
        System.out.println("logResult = " + logResult);


        //Log
        Logger logger = new Logger();
        SpaceInvader spaceInvader = new SpaceInvader(properties, powerfulAlienLocations, invulnerableAlienLocations, multipleAlienLocations);
        System.out.println("logResult = " + logger.getLog());
    }

    public static ArrayList<AlienGridLocation> convertFromProperty(Properties properties, String propertyName) {
        String alienString = properties.getProperty(propertyName);
        ArrayList<AlienGridLocation> alienLocations = new ArrayList<>();
        if (alienString != null) {
            String[] locations = alienString.split(";");
            for (String location : locations) {
                String[] locationPair = location.split("-");
                int rowIndex = Integer.parseInt(locationPair[0]);
                int colIndex = Integer.parseInt(locationPair[1]);
                alienLocations.add(new AlienGridLocation(rowIndex, colIndex));
            }
        }
        return alienLocations;
    }
}

