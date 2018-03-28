package ng.dat.ar;

/**
 * Created by daviddryburgh on 28/03/2018.
 */

public class Tours
{
    private String tour_id;
    private String name;
    private String description;
    private String distance;
    private String est_time;
    private String start_latitiude;
    private String start_longitude;
    private String start_altitude;
    private String end_latitude;
    private String end_longitude;
    private String end_altitude;

    public Tours(String id, String n)
    {
        setTour_id(id);
        setName(n);
    }

    public Tours(String id, String n, String descrip, String dist, String time, String s_lat, String s_lon, String s_alt, String e_lat, String e_lon, String e_alt)
    {
        setTour_id(id);
        setName(n);
        setDescription(descrip);
        setDistance(dist);
        setEst_time(time);
        setStart_latitiude(s_lat);
        setStart_longitude(s_lon);
        setStart_altitude(s_alt);
        setEnd_latitude(e_lat);
        setEnd_longitude(e_lon);
        setEnd_altitude(e_alt);
    }

    public String getTour_id() {
        return tour_id;
    }

    public void setTour_id(String tour_id) {
        this.tour_id = tour_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDistance() {
        return distance;
    }

    public void setDistance(String distance) {
        this.distance = distance;
    }

    public String getEst_time() {
        return est_time;
    }

    public void setEst_time(String est_time) {
        this.est_time = est_time;
    }

    public String getStart_latitiude() {
        return start_latitiude;
    }

    public void setStart_latitiude(String start_latitiude) {
        this.start_latitiude = start_latitiude;
    }

    public String getStart_longitude() {
        return start_longitude;
    }

    public void setStart_longitude(String start_longitude) {
        this.start_longitude = start_longitude;
    }

    public String getStart_altitude() {
        return start_altitude;
    }

    public void setStart_altitude(String start_altitude) {
        this.start_altitude = start_altitude;
    }

    public String getEnd_latitude() {
        return end_latitude;
    }

    public void setEnd_latitude(String end_latitude) {
        this.end_latitude = end_latitude;
    }

    public String getEnd_longitude() {
        return end_longitude;
    }

    public void setEnd_longitude(String end_longitude) {
        this.end_longitude = end_longitude;
    }

    public String getEnd_altitude() {
        return end_altitude;
    }

    public void setEnd_altitude(String end_altitude) {
        this.end_altitude = end_altitude;
    }

}
