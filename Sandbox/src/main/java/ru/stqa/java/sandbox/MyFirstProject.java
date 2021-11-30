package ru.stqa.java.sandbox;

public class MyFirstProject {

 public static void main(String[] args) {
  Point p1 = new Point (3.7, 4.2);
  Point p2 = new Point (2.1, 7.5);

  System.out.println("Расстояние между двумя точками " + "= " + distance(p1,p2));

  System.out.println("Hello, world!");
 }

 public static double distance(Point p1, Point p2) {
 return Math.sqrt((p2.x - p1.x) * (p2.x - p1.x) + (p2.y - p1.y) * (p2.y - p1.y));
 }
}

