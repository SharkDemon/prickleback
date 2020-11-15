package com.simco.prickleback.model;

public enum Grade {

    A("Rock Superstar", 95),
    B("Rockstar", 75),
    C("Rocker", 50),
    D("Opening Act", 25),
    E("Roadie", 0);

    private final String displayName;
    // minimum percentage of scoring earned to earn this Grade level
    private int threshold;

    Grade(String displayName, int threshold) {
        this.displayName = displayName;
        this.threshold = threshold;
    }

    public String getDisplayName() {
        return displayName;
    }

    public int getThreshold() {
        return threshold;
    }

}
