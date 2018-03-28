package ng.dat.ar;

/**
 * Created by daviddryburgh on 28/03/2018.
 */

public class Pois
{
    private String id, name, lat, lon, alt;

    public Pois(String poid, String n, String la, String lo, String a) {
        setId(poid);
        setName(n);
        setLat(la);
        setLon(lo);
        setAlt(a);
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLat() {
        return lat;
    }

    public void setLat(String lat) {
        this.lat = lat;
    }

    public String getLon() {
        return lon;
    }

    public void setLon(String lon) {
        this.lon = lon;
    }

    public String getAlt() {
        return alt;
    }

    public void setAlt(String alt) {
        this.alt = alt;
    }
}
