package jai;

/**
 *
 * @author Pedro
 */
public enum ImageType {

    PNG("PNG"),
    TIF("TIF"),
    JPG("JPG");

    private final String type;

    ImageType(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }

}
