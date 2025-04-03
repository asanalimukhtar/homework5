import java.util.HashMap;
import java.util.Map;

public class MarkerFactory {
    private static final Map<String, Marker> markers = new HashMap<>();
    public static Marker getMarker(String key) {
                    // If marker style for this type doesn't exist, create it.
        markers.putIfAbsent(key, createMarker(key));
        return markers.get(key);
    }
    private static Marker createMarker(String key) {
        switch(key) {
            case "GasStation":
                return new MapMarker(key, "GasIcon.png", "Red", "Bold");
            case "Restaurant":
                return new MapMarker(key, "RestIcon.png", "Blue", "Italic");
            case "Hospital":
                return new MapMarker(key, "HospIcon.png", "Green", "Regular");
            default:
                return new MapMarker(key, "DefaultIcon.png", "Black", "Regular");
        }}
                   // Returns the number of unique marker style objects created
    public static int getUniqueMarkerCount() {
        return markers.size();
    }
}