package jsonaction;

public class BusRoute {
    
    private String busName=null;
    double Coordination[] =new double[1000];

    public String getBusName() {
        return busName;
    }

    public void setBusName(String busName) {
        this.busName = busName;
    }

    public double[] getCoordination() {
        return Coordination;
    }

    public void setCoordination(double[] Coordination) {
        this.Coordination = Coordination;
    }
}
