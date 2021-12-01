package ru.stqa.java.sandbox;

public class MyFirstProject {

 public static void main(String[] args) {
  Point p1 = new Point (3.9, 1.0);
  Point p2 = new Point (2.1, 7.9);

  System.out.println("Расстояние между двумя точками " + "= " + p1.distance(p2));
 }
}

