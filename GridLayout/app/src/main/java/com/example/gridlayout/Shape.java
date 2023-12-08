package com.example.gridlayout;

public class Shape {
    int shapeImg;
    String shapeName;

    public int getShapeImg() {
        return shapeImg;
    }

    public void setShapeImg(int shapeImg) {
        this.shapeImg = shapeImg;
    }

    public String getShapeName() {
        return shapeName;
    }

    public void setShapeName(String shapeName) {
        this.shapeName = shapeName;
    }

    public Shape(int shapeImg, String shapeName) {
        this.shapeImg = shapeImg;
        this.shapeName = shapeName;
        System.out.println("Shape constructor called" + this.shapeName + this.shapeImg);
    }
}
