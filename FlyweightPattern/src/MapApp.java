public class MapApp {
    public static int randomX() {
        return (int)(Math.random() * 1000);
    }
    public static int randomY() {
        return (int)(Math.random() * 1000);
    }
    public static void main(String[] args) {
        int totalMarkers = 10000;
        String[] types = {"GasStation", "Restaurant", "Hospital"};

        for (int i = 0; i < totalMarkers; i++) {
            String type = types[(int)(Math.random() * types.length)];
            Marker marker = MarkerFactory.getMarker(type);
            marker.draw(randomX(), randomY());
        }
        System.out.println("Unique marker styles: " + MarkerFactory.getUniqueMarkerCount());
        System.out.println("Total markers drawn: " + totalMarkers);
    }
}