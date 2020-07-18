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
    private String name;
    private double rating;
    private double distance;
    private double amount;

    public Request(int userId, long requestId, String loc, String bus, double yAmt, double eAmt, double mDist, double mWait,String nme, double rtng, double dist, double amt){
        location = loc;
        business = bus;
        yourAmount = yAmt;
        expectedAmount = eAmt;
        maxDist = mDist;
        maxWait = mWait;
        name = nme;
        rating = rtng;
        distance = dist;
        amount = amt;
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

    public String getName(){
        return name;
    }

    public double getRating() {
        return rating;
    }

    public double getDistance() {
        return distance;
    }

    public double getAmount() {
        return amount;
    }
}
