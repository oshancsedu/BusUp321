package jsonaction;

public class StandDetail {
    
    private String StandName;
    private Double latUp,latDown,longUp,longDown;

    public String getStandName() {
        return StandName;
    }

    public void setStandName(String StandName) {
        this.StandName = StandName;
    }

    public Double getLatUp() {
        return latUp;
    }

    public void setLatUp(Double latUp) {
        this.latUp = latUp;
    }

    public Double getLatDown() {
        return latDown;
    }

    public void setLatDown(Double latDown) {
        this.latDown = latDown;
    }

    public Double getLongUp() {
        return longUp;
    }

    public void setLongUp(Double longUp) {
        this.longUp = longUp;
    }

    public Double getLongDown() {
        return longDown;
    }

    public void setLongDown(Double longDown) {
        this.longDown = longDown;
    }
}
