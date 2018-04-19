package ng.dat.ar;

public class ThePreferences
{
    private String id;
    private String title;

    public ThePreferences(String id, String title) {
        setId(id);
        setTitle(title);
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }


}
