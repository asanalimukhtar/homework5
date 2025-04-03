// AuthProxy restricts upload and change operations to logged-in agents.
public class AuthProxy implements Img {
    private Img img;
    private boolean auth; // true if agent is logged in

    public AuthProxy(Img img, boolean auth) {
        this.img = img;
        this.auth = auth;
    }

    @Override
    public void showThumb() {
        img.showThumb();
    }

    @Override
    public void zoom() {
        img.zoom();
    }

    @Override
    public void up(String file) {
        if (!auth) {
            System.out.println("Access denied: Not logged in.");
        } else {
            img.up(file);
        }
    }

    @Override
    public void change(String file) {
        if (!auth) {
            System.out.println("Access denied: Not logged in.");
        } else {
            img.change(file);
        }
    }
}