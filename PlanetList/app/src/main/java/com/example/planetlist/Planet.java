package com.example.planetlist;

// model class for planet
public class Planet {
    private String planetName;
    private int moonCount;
    private int planetImage;

    // constructor
    public Planet(String planetName, int moonCount, int planetImage) {
        this.planetName = planetName;
        this.moonCount = moonCount;
        this.planetImage = planetImage;
    }

    public String getPlanetName() {
        return planetName;
    }

    public void setPlanetName(String planetName) {
        this.planetName = planetName;
    }

    public int getMoonCount() {
        return moonCount;
    }

    public void setMoonCount(int moonCount) {
        this.moonCount = moonCount;
    }

    public int getPlanetImage() {
        return planetImage;
    }

    public void setPlanetImage(int planetImage) {
        this.planetImage = planetImage;
    }
}
