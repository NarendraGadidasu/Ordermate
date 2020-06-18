package android.example.connect;

public class Request {

    private int userId;
    private long requestId;
    private String location;
    private String business;
    private double yourAmount;
    private double expectedAmount;
    private double maxDist;
    private double maxWait;

    public Request(int userId, long requestId, String loc, String bus, double yAmt, double eAmt, double mDist, double mWait){
        location = loc;
        business = bus;
        yourAmount = yAmt;
        expectedAmount = eAmt;
        maxDist = mDist;
        maxWait = mWait;
    }

    public String getLocation() {
        return location;
    }

    public String getBusiness() {
        return business;
    }

    public double getYourAmount() {
        return yourAmount;
    }

    public double getExpectedAmount() {
        return expectedAmount;
    }

    public double getMaxDist() {
        return maxDist;
    }

    public double getMaxWait() {
        return maxWait;
    }
}
