// this part contains client code demonstrating the use of lazy loading and protective proxies
public class Demo {
    public static void main(String[] args) {
        // Create a lazy loading proxy for a property image
        Img img = new ImgProxy("estate.jpg");
        img.showThumb();  // Immediately display the thumbnail
        // When the user zooms in, the full-res image is loaded and displayed
        img.zoom();
        // if you try without authorizations
        Img noAuth = new AuthProxy(img, false);
        noAuth.up("new_estate.jpg");
        // With authorization, the upload is permitted
        Img auth = new AuthProxy(img, true);
        auth.up("new_estate.jpg");
    }
}