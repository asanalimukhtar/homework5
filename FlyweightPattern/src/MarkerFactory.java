import java.util.HashMap;
import java.util.Map;

public class MarkerFactory {
    private static final Map<String, Marker> markers = new HashMap<>();
    public static Marker getMarker(String key) {

        markers.putIfAbsent(key, createMarker(key));
        return markers.get(key);
    }
    private static Marker createMarker(String key) {
        switch(key) {
            case "GasStation":
                return new MapMarker(key, "GasIcon.png", "Green", "Bold");
            case "Restaurant":
                return new MapMarker(key, "RestIcon.png", "Blue", "Italic");
            case "Hospital":
                return new MapMarker(key, "HospIcon.png", "Red", "Regular");
            default:
                return new MapMarker(key, "DefaultIcon.png", "Black", "Regular");
        }
    }
    public static int getUniqueMarkerCount() {
        return markers.size();
    }
}