package poc.personal.togglemanager.models;

public class Toggle {

    private String id;
    private boolean active;


    public String getId() {

        return id;
    }

    public void setId(final String id) {

        this.id = id;
    }

    public boolean isActive() {

        return active;
    }

    public void setActive(final boolean active) {

        this.active = active;
    }
}
