// RealImg is the real object that represents a high-res property image
public class RealImg implements Img {
    String name;

    public RealImg(String name) {
        this.name = name;
        loadImage();
    }

    // Simulate a heavy image load operation
    private void loadImage() {
        System.out.println("Loading high-res image: " + name);
    }

    @Override
    public void showThumb() {
        System.out.println("Showing thumbnail for " + name);
    }

    @Override
    public void zoom() {
        System.out.println("Showing full-res image: " + name);
    }

    @Override
    public void up(String file) {
        System.out.println("Uploading image: " + file);
    }

    @Override
    public void change(String file) {
        System.out.println("Changing image to: " + file);
    }
}