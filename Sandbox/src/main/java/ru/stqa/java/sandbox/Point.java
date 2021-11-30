package ru.stqa.java.sandbox;

public class Point {

    public double x1;
    public double y1;
    public double x2;
    public double y2;


    public void p1(double x1, double y1) {
        this.x1 = x1;
        this.y1 = y1;
    }

    public void p2(double x2, double y2) {
        this.x2 = x2;
        this.y2 = y2;
    }

    public double distance() {
        return Math.sqrt((this.x2 - this.x1) * (this.x2 - this.x1) + (this.y2 - this.y1) * (this.y2 - this.y1));
    }
}