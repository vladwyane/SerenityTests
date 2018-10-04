package data;

/**
 * Created by bigdrop on 10/2/2018.
 */
public enum LocationsData {

    CHERRY_HILL ("Cherry", "NJ Cherry Hill - Hand and Stone"),
    EASTON ("Easton", "PA Easton PA - Hand and Stone"),
    DE_BEAR("Bear", "DE Bear - Hand and Stone");

    public String getShortLocationName() {
        return shortLocationName;
    }

    public String getLocationNameForMillenium() {
        return locationNameForMillenium;
    }

    private String shortLocationName;

    private String locationNameForMillenium;

    LocationsData(String shortLocationName, String locationNameForMillenium) {
        this.shortLocationName = shortLocationName;
        this.locationNameForMillenium = locationNameForMillenium;
    }
}
