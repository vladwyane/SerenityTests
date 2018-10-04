package data;

/**
 * Created by bigdrop on 10/3/2018.
 */
public enum DateTime {

    SEPTEMBER28_03PM("Sep 28", "03:00\nPM"),
    SEPTEMBER30_10AM ("Sep 10", "10:00\nAM"),
    OCTOBER04_3PM ("Oct 04", "03:00\nPM"),
    OCTOBER26_11AM ("Oct 26", "11:00\nAM"),
    OCTOBER29_06PM ("Oct 29", "06:00\nPM"),
    NOVEMBER23_6PM ("Nov 10", "06:00\nPM");

    public String getDate() {
        return date;
    }

    public String getTime() {
        return time;
    }

    private String date;
    private String time;

    DateTime(String date, String time) {
        this.date = date;
        this.time = time;
    }
}
