// ImgProxy implements IImage and provides lazy loading functionality.
public class ImgProxy implements Img {
    private String name;
    private RealImg real;

    public ImgProxy(String name) {
        this.name = name;
    }

    @Override
    public void showThumb() {
        System.out.println("Showing thumbnail for " + name);
    }

    @Override
    public void zoom() {
        if (real == null) {
            real = new RealImg(name);
        }
        real.zoom();
    }

    @Override
    public void up(String file) {
        if (real == null) {
            real = new RealImg(name);
        }
        real.up(file);
    }

    @Override
    public void change(String file) {
        if (real == null) {
            real = new RealImg(name);
        }
        real.change(file);
    }
}