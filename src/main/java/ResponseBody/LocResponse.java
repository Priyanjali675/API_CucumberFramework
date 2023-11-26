package ResponseBody;

public abstract class LocResponse implements LocationResponse{
    String status = null;
    String place_id=null;
    String name=null;
    public String getStatus() {
        return status;
    }
    @Override
    public String getPlace_id() {
        return place_id;
    }
    public String getName() {
        return name;
    }
}
