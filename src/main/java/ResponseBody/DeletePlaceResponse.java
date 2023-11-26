package ResponseBody;

public class DeletePlaceResponse extends LocResponse {
    String status;

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String getStatus() {
        return status;
    }


}
