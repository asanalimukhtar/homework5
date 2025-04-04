public class MapMarker implements Marker {
    private final String type;
    private final String icon;
    private final String color;
    private final String labelStyle;

    public MapMarker(String type, String icon, String color, String labelStyle) {
        this.type = type;
        this.icon = icon;
        this.color = color;
        this.labelStyle = labelStyle;
    }
    @Override
    public void draw(int x, int y) {
        System.out.println("Drawing " + type + " marker with icon '" + icon + "', color '" + color + "', label style '" + labelStyle
                + "' at (" + x + ", " + y + ")");

    }
}